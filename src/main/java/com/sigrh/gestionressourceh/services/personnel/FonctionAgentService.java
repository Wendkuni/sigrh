package com.sigrh.gestionressourceh.services.personnel;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.parametre.FonctionAgentDAOImplement;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelFonctionModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class FonctionAgentService implements InterfaceTemplete<PersonnelFonctionModel> {

    private  final FonctionAgentDAOImplement dao =new FonctionAgentDAOImplement(ConnectionDAO.getInstance());

    @Override
    public boolean create(PersonnelFonctionModel obj) {
        return dao.create(obj);
    }

    @Override
    public boolean delete(PersonnelFonctionModel obj) {
        return dao.delete(obj);
    }

    @Override
    public boolean update(PersonnelFonctionModel obj) {
        return dao.update(obj);
    }

    @Override
    public PersonnelFonctionModel find(int id) {
        return dao.find(id);
    }

    @Override
    public List<PersonnelFonctionModel> findAll() {
        return dao.findAll();
    }

    public boolean delete(Integer id) {
        return this.dao.delete(id);
    }

    public boolean update(Integer id, PersonnelFonctionModel m) {
        PersonnelFonctionModel model = find(id);
        if(model != null) {

            return this.update(model);
        }return false;
    }
}
