package com.sigrh.gestionressourceh.mappers.personnel;

import com.sigrh.gestionressourceh.common.util.DateUtil;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelAbsenceModel;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AbsenceMapper implements RowMapper<PersonnelAbsenceModel> {
    @Override
    public PersonnelAbsenceModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PersonnelAbsenceModel.builder()
                .idAbsence(rs.getLong("IDABSENCEA"))
                .autorisation(rs.getString("autorisation"))
                .motif(rs.getString("motif"))
                .dateeffet(rs.getDate("dateeffet"))
                .libelle(rs.getString("libelleab"))
                .nbJour(rs.getInt("nombrejr"))
                .signataire(rs.getString("signataire"))
                .personnel(PersonnelModel.builder().idAgent(rs.getInt("IDagent")).build())
                .build();
    }
}
