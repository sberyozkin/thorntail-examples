# Keycloak SAML Example

Simple JAX-RS application with Keycloak SAML example.

> Please raise any issues found with this example in our JIRA:
> https://issues.jboss.org/browse/THORN

This example shows a Thorntail JAX-RS service canbe secured by the Keycloak SAML adapter.

## Start Keycloak

### Keycloak Thorntail Server

Download the latest Thorntail Keycloak standalone server jar, for example, 2.4.0.Final version:

``` sh
wget http://repo2.maven.org/maven2/io.thorntail/servers/keycloak/2.4.0.Final/keycloak-2.4.0.Final-thorntail.jar .
```
and start it:

``` sh
THIS_EXAMPLE=/path/to/this/example
java -Dswarm.http.port=8180 \
     -Dkeycloak.migration.action=import \
     -Dkeycloak.migration.provider=dir \
     -Dkeycloak.migration.dir=${THIS_EXAMPLE}/realm \
     -jar keycloak-2.4.0.Final-thorntail.jar
```


### Local installed

``` sh
THIS_EXAMPLE=/path/to/this/example
cd $KEYCLOAK_HOME
bin/standalone.sh \
  -Djboss.socket.binding.port-offset=100 \
  -Dkeycloak.migration.action=import \
  -Dkeycloak.migration.provider=dir \
  -Dkeycloak.migration.dir=${THIS_EXAMPLE}/realm
```

### Docker

``` sh
docker run -it -d \
  -p 8180:8080 \
  -v `pwd`/realm:/tmp/realm \
  jboss/keycloak:4.8.3.Final \
  -b 0.0.0.0 \
  -Dkeycloak.migration.action=import \
  -Dkeycloak.migration.provider=dir \
  -Dkeycloak.migration.dir=/tmp/realm
```

## Build Example

``` sh
mvn clean package
```

## Access a secured resource from browser

### Start the example server


``` sh
java -jar target/example-keycloak-saml-thorntail.jar
```

### Access the JAX-RS endpoint from the browser

Navigate the browser to "http://localhost:8080/employee-sig"

You will be redirected to Keycloak, login with a user name 'bill' and a password 'password'.

You'll get the response which contains `Hi bill, this is Secured Resource'
