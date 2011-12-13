import com.tdbank.greenhornet.SecRole
import com.tdbank.greenhornet.User
import com.tdbank.greenhornet.SecUserSecRole

class BootStrap {

    def init = { servletContext ->
		initRolesAndUsers()
    }
	
	private void initRolesAndUsers() {
		def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)

		def adminUser = User.findByUsername('admin') ?: 
			new User(username: 'admin',
					 password: 'admin', // Spring Security Core now auto-encodes password
					 lastName: 'Admin',
					 firstName:'Captain',
					 enabled:  true).save(failOnError: true)
		if (!adminUser.authorities.contains(adminRole)) {
			SecUserSecRole.create adminUser, adminRole
		}
	}
	
    def destroy = {
    }
}
