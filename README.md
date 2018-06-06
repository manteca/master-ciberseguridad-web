## Running website  

### Installing all Dependency
#### Requirements:

- Python 2.7
- Java (JDK 1.8)

#### Steps:

Follow these steps to setup a local environment on your machine

1. Download Play! 1 from [here](https://downloads.typesafe.com/play/1.4.4/play-1.4.4.zip)
2. Unzip previous file
3. Add `play` to your PATH environment variable
4. Execute `play run`
5. Visit `http://localhost:9000`

### Running With Dokcer


Build you local image from the in the repository [dockerfile](https://docs.docker.com/engine/reference/builder/#usage)
`docker build -t user/image_name`

Run your container from the local images you just created ([info on how to run docker](https://docs.docker.com/))
`docker run -ti --rm  -v /place/where/the/folder/web/is:/app -p 9000:9000 user/image_name`


## IDE Integration:

In order to integrate application with an IDE you can run one of the following commands accordingly:

Eclipse: `play eclipsify`
IntelliJ: `play idea`

More info [here](https://www.playframework.com/documentation/1.4.x/ide)


## Development Documentation

If you need some help with development you can visit official documentation site

https://www.playframework.com/documentation/1.4.x/home
