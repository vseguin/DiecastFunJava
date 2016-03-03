package com.personal.diecastfun.daemons;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.controllers.service.ConfigFacade;
import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.QueuedCar;
import com.personal.diecastfun.domain.repositories.QueuedCarsRepository;

@Component
@DependsOn("carFacade")
public class AddCarsScheduledTask {

	private static final String FOLDER_NAME = "resources/images/cars-small/";
	private static final String PICTURES_EXTENSION = "-1.jpg";

	@Autowired
	private CarFacade carFacade;
	@Autowired
	private ConfigFacade configFacade;
	@Autowired
	private QueuedCarsRepository queuedCarsRepository;

	private AmazonS3 s3Client;

	public AddCarsScheduledTask() {
		s3Client = new AmazonS3Client(new DefaultAWSCredentialsProviderChain());
	}

	@Scheduled(fixedRate = 1000)
	public void reportCurrentTime() {
		queuedCarsRepository.findAll().forEach(c -> dequeueIfNeeded(c));
	}

	private void dequeueIfNeeded(QueuedCar queuedCar) {
		try {
			String key = FOLDER_NAME + queuedCar.generateId() + PICTURES_EXTENSION;

			System.out.println("Trying to get " + key + " from S3.");

			s3Client.getObject(new GetObjectRequest(configFacade.getBucketName(), key));

			System.out.println("Car " + queuedCar.getId() + " will be added!");

			Car car = new Car().withBrand(queuedCar.getBrand()).withModel(queuedCar.getModel())
					.withMaker(queuedCar.getMaker()).withEra(queuedCar.getEra()).withScale(queuedCar.getScale())
					.withColor(queuedCar.getColor()).withRestored(queuedCar.getRestored())
					.withCustomized(queuedCar.getCustomized())
					.withInsertionDate(new Date(new java.util.Date().getTime())).withTags(queuedCar.getTags())
					.withCount(queuedCar.getCount()).withId(queuedCar.generateId());

			carFacade.addCar(car);
			queuedCarsRepository.delete(queuedCar);
		} catch (AmazonS3Exception e) {
			System.out.println("Car " + queuedCar.getId() + " doesn't have any pictures for now.");
		}
	}
}
