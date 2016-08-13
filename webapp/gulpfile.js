var gulp = require('gulp');
var cleanCSS = require('gulp-clean-css');
var runSequence = require('run-sequence');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');

var cssPath = 'resources/css/*.css';
var jsPath = 'resources/js/*.js';

gulp.task('minify-css', function() {
	gulp.src([cssPath]).pipe(concat('app.min.css'))
			.pipe(gulp.dest('resources/target/css'));
});

gulp.task('minify-js', function() {
	gulp.src([ jsPath ]).pipe(concat('app.min.js')).pipe(uglify()).pipe(
			gulp.dest('resources/target/js'));
});

gulp.task('default', function() {
	runSequence('minify-css', 'minify-js');
});

gulp.task('watch', function() {
	gulp.watch(cssPath, [ 'minify-css' ]);
	gulp.watch(jsPath, [ 'minify-js' ]);
})