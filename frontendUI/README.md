# FrontendUI
This is a trial for docker image running this angular app
to run it open up cmd, navigate to the root folder of fromtendui and run
  docker build -t healthcheck/frontend-ui .

followed by (The command below binds the external port of 6001 to the default port of the server)
    docker run --rm -d -p 6001:80 healthcheck/frontend-ui
  
followed by creating docker compose
  version: '3.1'
  services:
    app:
      image: 'healhcheck/frontend-ui'
      build: '.'
      ports:
        - 6001:80
        
### Scripts to stop and remove image
  docker stop <containerid>
  docker rm <containerid>
  
  docker rmi <imageid>

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 7.1.0.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
