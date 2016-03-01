package com.ged.business;

public interface IRoleBusiness {
        
        public Role ajouterRole(Role role);

        public Collection<Role> getAllRoles();
        
        public Role getRoleById(Serializable id);
        
        public void attribuerAction(Role role, Action action);
        
        public void retirerAction(Role role, Action action);
        
        public void supprimerRole(Role role);
}
