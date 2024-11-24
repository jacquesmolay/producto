package todocode.com.producto.micro.component;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomeHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean databaseIsUp = checkDatabaseHealth();
        if (databaseIsUp) {
            return Health.up().withDetail("Database", "Available").build();
        }
        return Health.down().withDetail("Database", "Not Available").build();
    }

    private boolean checkDatabaseHealth() {
        // Lógica para verificar el estado de la base de datos
        return true;
    }
}
