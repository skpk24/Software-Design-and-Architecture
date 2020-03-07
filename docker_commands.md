### Docker commands

Create image and push it to server(hub.docker.com).

To check the version of the docker

  `$ docker -v `

To login

  `$ docker login`

To see number of running containers

  `$ docker ps -a`

To docker images available under the particular account.

  `$ docker images`

To build the docker image . (dot) is mandatory to represent the present working directory. Note: Repository name must be lower case.

  `$ docker build -t skpk24/spring_webflux .`

To run the build image

  `$ docker run -p 8080:8080 skpk24/spring_webflux `

To run the build image in background 

  `$ docker run -d -p 8080:8080 skpk24/spring_webflux `

To push the image to the docker hub.

  `$ docker push skpk24/spring_webflux`

To run the docker-compose [Compose is used only when we need to impor more than one container]

  `$ docker-compose up `


To pull the particular docker image

  `$ docker pull [image name or Id]`
