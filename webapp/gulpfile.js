require('es6-promise').polyfill();
var gulp = require('gulp');
var cleanCSS = require('gulp-clean-css');
var runSequence = require('run-sequence');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var sass = require('gulp-sass');
var autoprefix = require('gulp-autoprefixer');

var cssPath = 'resources/sass/*.scss';
var jsPath = 'resources/js/*.js';

gulp.task('minify-css', function() {
	gulp.src(['resources/sass/main.scss']).pipe(sass({
		outputStyle : 'compressed'
	})).pipe(concat('app.min.css')).pipe(autoprefix('last 10 version')).pipe(
			gulp.dest('resources/target/css'));
});

gulp.task('minify-js', function() {
	gulp.src([ jsPath ]).pipe(concat('app.min.js')).pipe(uglify()).pipe(
			gulp.dest('resources/target/js'));
});

gulp.task('default', function() {
	runSequence('minify-css', 'minify-js');
});

gulp.task('watch',['default'], function() {
	gulp.watch(cssPath, [ 'minify-css' ]);
	gulp.watch(jsPath, [ 'minify-js' ]);
})