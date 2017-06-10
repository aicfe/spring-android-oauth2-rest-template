package org.springframework.security.core;

/**
 * Internal class used for checking version compatibility in a deployed application.
 *
 * @author Luke Taylor
 * @author Rob Winch
 */
public class SpringSecurityCoreVersion {
    private static final String DISABLE_CHECKS = SpringSecurityCoreVersion.class
            .getName().concat(".DISABLE_CHECKS");

    /**
     * Global Serialization value for Spring Security classes.
     *
     * N.B. Classes are not intended to be serializable between different versions. See
     * SEC-1709 for why we still need a serial version.
     */
    public static final long SERIAL_VERSION_UID = 400L;

    static final String MIN_SPRING_VERSION = "4.2.2.RELEASE";

    static {
        performVersionChecks();
    }

    public static String getVersion() {
        Package pkg = SpringSecurityCoreVersion.class.getPackage();
        return (pkg != null ? pkg.getImplementationVersion() : null);
    }

    /**
     * Performs version checks
     */
    private static void performVersionChecks() {
        performVersionChecks(MIN_SPRING_VERSION);
    }

    /**
     * Perform version checks with specific min Spring Version
     *
     * @param minSpringVersion
     */
    private static void performVersionChecks(String minSpringVersion) {

    }

    /**
     * Disable if springVersion and springSecurityVersion are the same to allow working
     * with Uber Jars.
     *
     * @param springVersion
     * @param springSecurityVersion
     * @return
     */
    private static boolean disableChecks(String springVersion,
                                         String springSecurityVersion) {
        if (springVersion == null || springVersion.equals(springSecurityVersion)) {
            return true;
        }
        return Boolean.getBoolean(DISABLE_CHECKS);
    }
}
