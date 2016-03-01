package com.ged.business.impl;

import com.ged.domain.Action;
import com.ged.domain.Role;
import com.ged.dao.RoleRepository;

import java.util.Collection;

public class RoleBusinessImpl implements IRoleBusiness {

        @Autowired
        private RoleRepository roleRepository;
        
        @Override
        public Role ajouterRole(Role role) {
        
        }

        @Override
        public Collection<Role> getAllRoles() {
        
        }
        
        @Override
        public Role getRoleById(Serializable id) {
        
        }
        
        @Override
        public void attribuerAction(Role role, Action action) {
        
        }
        
        @Override
        public void retirerAction(Role role, Action action) {
        
        }
        
        @Override
        public void supprimerRole(Role role) {
        
        }
        
}
