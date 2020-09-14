package health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Simple service check
 */
public class CollegeSuiteHealthCheck extends HealthCheck {

    /**
     * Creates an instance of this healthcheck
     */
    public CollegeSuiteHealthCheck() {
        super();
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
