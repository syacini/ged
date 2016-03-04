package com.ged.confighelper;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.ged.util.Constants;

@Component
public class CurrentTeantResolverImpl implements CurrentTenantIdentifierResolver {

	@Override
	public String resolveCurrentTenantIdentifier() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if (requestAttributes != null) {
			String identifier = (String) requestAttributes.getAttribute(Constants.CURRENT_TENANT_IDENTIFIER,
					RequestAttributes.SCOPE_REQUEST);
			if (identifier != null) {
				return identifier;
			}
		}
		return Constants.UNKNOWN_TENANT;
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}

}
