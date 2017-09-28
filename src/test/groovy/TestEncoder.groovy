@Grab('org.springframework.security:spring-security-core:4.1.1.RELEASE')
import org.springframework.security.*
import static groovy.test.GroovyAssert.assertNotNull

// First argument is the password.
// Second optional password is the secret.

switch(args.size()) {
  case 1:
    password = args[0]
    encoder = new crypto.password.StandardPasswordEncoder()
    break
  case 2:
    password = args[0]
    secret = args[1]
    encoder = new crypto.password.StandardPasswordEncoder(secret)
    break
  default:
    throw new IllegalArgumentException("I require at least one arguement - the password. Optionally a second argument is the secret")
}

// Sanity - check password has been set.
assertNotNull password
assertNotNull encoder

// We should only get one line...
System.in.eachLine { line ->
  assert encoder.matches(password,line)
}
