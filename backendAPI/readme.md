he video to see how to deploy angular and spring together

https://www.youtube.com/watch?v=JJoBUdMJf1I


###Docker image
to build, open up the terminal on the root folder and build the image
	docker build -t healtcheck/backend-api .
to rum the image
        docker run --rm -d -p 5001:8080 healtcheck/backend-api
to see the logs
	docker logs -f <containerimage>
