package org;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {
                @Tag(name="Simian", description="Validate Simian DNA.")
        },
        info = @Info(
                title="Simian API",
                version = "1.0.0-SNAPSHOT",
                contact = @Contact(
                        name = "Simian API Support",
                        email = "wescley13sri@gmail.com"))
)
public class SimianApplication extends Application {
}
