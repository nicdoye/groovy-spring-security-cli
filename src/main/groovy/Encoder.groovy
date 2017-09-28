// @Grab('org.springframework.security:spring-security-core:4.1.1.RELEASE')
import org.springframework.security.*
import static groovy.test.GroovyAssert.assertNotNull

// First argument is the password.
// Second optional password is the secret.

class Encoder {

  def password
  def secret
  def encoder

  def assertNotNulls(Object... variables) {
    variables.each { assertNotNull it }
  }

  def checkAnswer(encodedPassword) {
    assert encoder.matches(password,encodedPassword)
    assertNotNull encodedPassword   
  }

  def checkCommandLineArguments(String[] commandLineArguments) {
    switch(commandLineArguments.size()) {
    case 1:
      password = commandLineArguments[0]
      encoder = new crypto.password.StandardPasswordEncoder()
      break
    case 2:
      password = commandLineArguments[0]
      secret = commandLineArguments[1]
      encoder = new crypto.password.StandardPasswordEncoder(secret)
      break
    default:
      throw new IllegalArgumentException("""I require at least one arguement - the password.
  Optionally a second argument can be passed that is the secret""")
    }
  }
  
  def run(String[] commandLineArguments) {
    checkCommandLineArguments(commandLineArguments)
    assertNotNulls(password, encoder)
    encodedPassword = encoder.encode(password)
    checkAnswer(encodedPassword)
    println encodedPassword
  }


  static main(args) {
    run(args)
  }
}