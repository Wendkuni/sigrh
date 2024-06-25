package com.sigrh.gestionressourceh.services.personnel;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.common.util.ImageUtil;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.personnel.PersonnelDAOImplement;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
@Transactional
public class PersonnelService implements InterfaceTemplete<PersonnelModel> {

   private final PersonnelDAOImplement daoImplement= new PersonnelDAOImplement(ConnectionDAO.getInstance());


    @Override
    public boolean create(PersonnelModel obj) {

        return this.daoImplement.create(obj);
    }

    public boolean create(MultipartFile imageFile, PersonnelModel obj) throws IOException {
    	obj.setImagPers(imageFile.getBytes());
    	return this.daoImplement.create(obj);
    }

    @Override
    public boolean delete(PersonnelModel obj) {
        return false;
    }

    @Override
    public boolean update(PersonnelModel obj) {
        return this.daoImplement.update(obj);
    }

    @Override
    public PersonnelModel find(int id) {
        return this.daoImplement.find(id);
    }

    @Override
    public List<PersonnelModel> findAll() {
        return this.daoImplement.findAll();
    }



    public boolean delete(Integer id) {
        return this.daoImplement.delete(id);
    }

    public boolean update(Integer id, PersonnelModel m) {
        PersonnelModel model = find(id);
        if(model != null) {
            model.setNni(m.getNni());
            model.setNomPrenom(m.getNomPrenom());
            model.setMatricule(m.getMatricule());
            model.setNumroCpte(m.getNumroCpte());
            model.setLieuNaiss(m.getLieuNaiss());
            model.setBank(m.getBank());
            model.setImagPers(m.getImagPers());
            model.setCleRib(m.getCleRib());
            model.setCodeBank(m.getCodeBank());
            model.setAdressEmp(m.getAdressEmp());
            model.setActifOrNot(m.getActifOrNot());
            model.setDateNaiss(m.getDateNaiss());
            model.setDebutCntrat(m.getDebutCntrat());
            model.setDetacher(m.getDetacher());
            model.setDteRecrutement(m.getDteRecrutement());
            model.setDteSortie(m.getDteSortie());
            model.setDteTitularisation(m.getDteTitularisation());
            model.setFinCntrat(m.getFinCntrat());
            model.setNomPrenomArab(m.getNomPrenomArab());
            model.setMinisterOrigine(m.getMinisterOrigine());
            model.setStatusEmp(m.getStatusEmp());
            model.setTlphone(m.getTlphone());
            model.setTypeeducation(m.getTypeeducation());
            return this.update(model);
        }
        return false;
    }
    public List<PersonnelModel> findByAffectation(int id) {
        return this.daoImplement.findByAffectation(id);
    }

    public List<PersonnelModel> findByLocalite(String localite) {
        return this.daoImplement.findByLocalite(localite);
    }

    public byte[] getImage(int id) throws DataFormatException, IOException {
        PersonnelModel dbImage = this.find(id);
        return dbImage.getImagPers();
    }

}
