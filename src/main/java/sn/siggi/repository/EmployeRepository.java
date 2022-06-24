/**
 * 
 */
package sn.siggi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.siggi.domaine.Employe;

/**
 * @author nabyFall
 *
 */
public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}
