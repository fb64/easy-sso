# Easy SSO

The purpose of this repository is to show how to simply secure with free and opensource components any web application with Open ID connect and provide SSO login without modifying it.

## Getting started
[docker compose](https://docs.docker.com/compose/) is required to run this example

Add the following line to your hosts file to make domain names available on your computer

``127.0.0.1	python.local java.local keycloak.local static.local``

Run the following commands to run the example

```Shell
# build images
docker compose build

# run containers
docker compose up
```

Following application are now available on your computer 


| URL                        | Credentials                      | Description         |
|----------------------------|----------------------------------|---------------------|
| http://keycloak.local:8080 | user: admin<br>password: admin   | Keycloak admin page |
| http://localhost:8888      | N/A (publicly available)         | Apache public page  |
| http://python.local:8888   | user: python<br>password: python | Python webapp       |
| http://java.local:8888     | user: user<br>password: user     | Java webapp         |


## Logout
You can logout to both application and identity provider by using front channel logout urls
http://java.local:8888/redirect_oidc?logout=get  
http://python.local:8888/redirect_oidc?logout=get

See [module documentation](https://github.com/OpenIDC/mod_auth_openidc/wiki#9-how-do-i-logout-users) for more details about logout. 



## Architecture

<img src="misc/easy-sso.svg" alt="easy-sso architecture diagram">

### Keycloak

[Keycloak](https://www.keycloak.org/) is an opensource Identity and Access Management tool used as an Open Id Connect Identity provider.
For this example a pre-configured realm with an A OpenID connect client named apache-oidc that allows Apache web server to authenticate user.


### Apache HTTPD + OIDC module

Apache web server is used as a reverse proxy to handle any public network request and ensure SSO protection thanks to [ODIC module](https://github.com/zmartzone/mod_auth_openidc).
For this example a docker image based on official httpd image is build to add OIDC module and change web server configuration.

### Python App

Python app is a minimal python web application that uses [Flask](https://flask.palletsprojects.com/) framework.

### Java App

Java app is a minimal java web application that uses [Spring Boot](https://spring.io/projects/spring-boot) framework.

