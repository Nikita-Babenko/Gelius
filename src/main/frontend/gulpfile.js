require('harmonize')();

var gulp = require('gulp');
var uglify = require('gulp-uglify');
var browserify = require('browserify');
var babelify = require('babelify');
var source = require('vinyl-source-stream');
var jest = require('gulp-jest');
var chalk = require('chalk');
var streamify = require('gulp-streamify');

gulp.task('apply-prod-environment', function () {
    process.env.NODE_ENV = 'production';
});

gulp.task('compile', function(){
    browserify('./js/productRegister.js')
        .transform(babelify)
        .bundle()
        .on('error', function(err){
            console.log(chalk.bold.red(err));
        })
        .pipe(source('productRegister.js'))
        .pipe(streamify(uglify()))
        .pipe(gulp.dest('../webapp/WEB-INF/resources/js'));
});

gulp.task('compile', function(){
    browserify('./js/Product.js')
        .transform(babelify)
        .bundle()
        .on('error', function(err){
            console.log(chalk.bold.red(err));
        })
        .pipe(source('newProduct.js'))
        .pipe(gulp.dest('../webapp/WEB-INF/resources/js'));
});

gulp.task('jest', function(){
    gulp.src('src/**/*-test.js')
        .pipe(jest({
            rootDir : 'src',
            scriptPreprocessor : "../node_modules/babel-jest",
            testFileExtensions : ["es6", "js"],
            moduleFileExtensions : ["js", "json", "es6"],
            unmockedModulePathPatterns : ["./node_modules/react"]
        }));
});

gulp.task('watch', function(){
    gulp.watch(['src/**/*.js*'], ['compile']);
});

gulp.task('default', ['apply-prod-environment', 'compile']);

gulp.task('test', ['jest']);