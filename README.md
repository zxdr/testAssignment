# Task for Omnicomm company #

[![Spec](https://img.shields.io/badge/spec_Omnicomm-22933F)](https://developers.omnicomm.ru/)

## What is the task? ##
- automate any test case for the first end-point `/auth/login`

## What have I done? ##
- wrote 2 positive tests with Spock framework, groovy
- made api and models generation that anyone can run with gradle task `openApiGenerate`. configurations in build.gradle. 
to start generation use `Run configurations -> openApiGenerate`
- found some bugs such as incorrect error message and illegal json schema in spec 

## What should I do next? ##
- add Allure report 
- rewrite ApiClient or use some other solutions that will give an opportunity to handle different behavior of Server