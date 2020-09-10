<img src="src/main/resources/yaloTwitter.jpg" align="right" />

# yaloChallenge
###This basic automation framework is part of the challenge proposed by Yalo company

>This project implements Cucumber Framework along with Springboot and Maven tools

Some of the characteristics currently supported by this framework are:
- REST API calls (Supported HTTP methods [GET,PUT,POST,DELETE]).
- Assert Json object using JsonPath & Jayway.
- Maven Profile for easy management of environments and run time pick up variables.
- Dependency Injection using Pico Container for easy object state sharing.


## How this works?
Cucumber Framework relates Sentences in Gherkin(a high level descriptive language) to functions from an actual programing language.

### Example:
_Gherkin_
```gherkin
  Given I make a GET request to "<UID>"
```

_Java_
```java
@Given("^I make a GET request to \"([^\"]*)\"$")
      public void i_make_a_GET_request_to(String url) {
      this.restClient.get(url);
      }
```

the advantage of this is that it will let you reuse the same function in future scenarios by creating a modular framework you just need to code once and then just to the set up of the parameters for a given API.

##Maven Profiles
By using Maven profiles instead of the common cucumber goal for running scenarios it will give you more flexibility and control of the project
you can specify Environment/Credentials/Tags and pretty much any parameter that you need.

#### How do I run entire project?
simple use general maven goal
```maven
  mvn clean test -P Dev
```
#### What about running just one scenario?
add the @RunThis annotation at the beginning of the scenario or even the feature file, All scenarios marked as @RunThis would run with this command 
```maven
  mvn clean test -P Dev,RunThis
```
#### What about ignoring scenario?
Ignore tag is very helpful for when a scenario is broken and is under fixing during development lifecycles you just need to add the @Ignore annotation
```maven
  mvn clean test -P Dev,Ignore
```