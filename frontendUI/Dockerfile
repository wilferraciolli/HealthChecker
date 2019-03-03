### STAGE 1: Build ###

#Get node and label as node
FROM node:latest as node

#set the working dir
WORKDIR /app

#copy everything from current content onto docker image app folder
COPY . .

#run npm to resolve dependeenies
RUN npm install

## build the application
RUN npm run build --prod


### STAGE 2: Setup, used for running the application ###
FROM nginx:alpine

## Copy our default nginx config
#COPY nginx/default.conf /etc/nginx/conf.d/

## Remove default nginx website
#RUN rm -rf /usr/share/nginx/html/*

## From 'node' stage copy over the artifacts in dist folder to default nginx public folder
COPY --from=node /app/dist/frontendUI /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]
