/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class.SistOperacije;

import Class.DAO.BrokerDAO;
import Class.Apstraktne.AbstractDAO;
import Class.Apstraktne.Opsta;
import java.sql.SQLException;

/**
 *
 * @author neso
 */
public class VratiListuSO extends Opsta {

    public VratiListuSO(BrokerDAO brokerDAO) {
        super(brokerDAO);
    }

    protected String formirajRec(BrokerDAO brokerDAO) throws SQLException {
        return (brokerDAO.RecListSve());
    }

    protected Object izvrsiRec(BrokerDAO brokerDAO) throws SQLException {
        Object result = brokerDAO.izvrsiListu();
        return result;
    }
}
