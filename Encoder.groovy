@Grab('org.springframework.security:spring-security-core:4.1.1.RELEASE')
import org.springframework.security.*

println new crypto.password.StandardPasswordEncoder().encode(args[0])