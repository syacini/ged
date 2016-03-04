package com.ged.confighelper;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ged.dao.master.UserRepository;
import com.ged.domain.master.User;
import com.ged.util.Constants;

@Component
public class TenantIdentifierInterceptorAdapter extends HandlerInterceptorAdapter {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getUserPrincipal() != null) {
			Optional<User> uo = userRepository.findOneByUsername(request.getUserPrincipal().getName());
			if (uo.isPresent()) {
				// Set the organization key as tenant identifier
				request.setAttribute(Constants.CURRENT_TENANT_IDENTIFIER,
						uo.get().getOrganization().getOrganizationKey());
			}
		}
		return true;
	}
}
