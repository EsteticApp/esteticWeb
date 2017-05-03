package edu.eci.cosw;

import edu.eci.cosw.Interfaz.User;
import edu.eci.cosw.Interfaz.repositorio.*;
import edu.eci.cosw.controllersAPI.UserControllerApi;
import edu.eci.cosw.models.*;
import edu.eci.cosw.service.ApplicationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsteticappApplicationTests {


	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ServicesRepository servicesRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ProfessionalHasServicesRepository phsRepo;
	@Autowired
	private ProfessionalRepository professionalRepository;
	@Autowired
	private ApplicationService applicationService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getCategoryTest(){
		Categories cat = categoryRepository.findOne(1);
		Assert.assertNotNull(cat);
	}

	@Test
	public void getServicesByCategoryTest(){
		List<Services> services = servicesRepository.getServicesByCategory(1);
		Assert.assertNotNull(services);
		Assert.assertFalse(services.isEmpty());
	}

	@Test
	public void getServicesTest(){
		List<Services> services = servicesRepository.findAll();
		Assert.assertNotNull(services);
		Assert.assertFalse(services.isEmpty());
	}

	@Test
	public void addServiceTest(){
		Categories cat = categoryRepository.findOne(1);
		List<Services> ser = servicesRepository.findAll();
		boolean exist = false;
		for (Services s : ser){
			if(s.getName().equals("Nanomax")) {
				exist = true;
				break;
			}
		}
		if (!exist){
			Services service = new Services("Nanomax");
			cat.getServices().add(service);
			categoryRepository.saveAndFlush(cat);
			exist = true;
		}
		Assert.assertTrue(exist);
	}

	@Test
	public void getReservationsTest(){
		List<Reservations> reservationsList = reservationRepository.findAll();
		Assert.assertNotNull(reservationsList);
		Assert.assertFalse(reservationsList.isEmpty());
	}

	@Test
	public void getReservationByStateTest(){
		List<Reservations> reservationsList = reservationRepository.getReservationByState("Aceptada");
		Assert.assertNotNull(reservationsList);
		Assert.assertFalse(reservationsList.isEmpty());
	}

	@Test
	public void getPHSsTest(){
		List<ProfessionalHasServices> phsList = phsRepo.findAll();
		for(ProfessionalHasServices phs : phsList){
			System.out.println("_______________________________________________");
			System.out.println(phs.getProfessional().getName());
			System.out.println(phs.getServices().getName());
		}
		Assert.assertNotNull(phsList);
	}

	@Test
	public void getPHSsByService(){
		List<ProfessionalHasServices> phsList = phsRepo.getPHSsByServiceID(1);
		System.out.println("getPHSsByServiceID output");
		for(ProfessionalHasServices phs : phsList){
			System.out.println("_______________________________________________");
			System.out.println(phs.getProfessional().getName());
			System.out.println(phs.getServices().getName());
		}
		Assert.assertNotNull(phsList);
	}

	@Test
	public void getPHSsByProfessional(){
		List<ProfessionalHasServices> phsList = phsRepo.getPHSsByProfessionalID(1);
		System.out.println("getPHSsByProfessionalID output");
		for(ProfessionalHasServices phs : phsList){
			System.out.println("_______________________________________________");
			System.out.println(phs.getProfessional().getName());
			System.out.println(phs.getServices().getName());
		}
		Assert.assertNotNull(phsList);
	}

	@Test
	public void addProfessionalTest(){

		List<Professional> professionalList = professionalRepository.findAll();
		boolean exist = false;
		for (Professional p : professionalList){
			if(p.getName().equals("Profesional UTest")) {
				exist = true;
				break;
			}
		}
		if (!exist){
			Professional professional = new Professional("Profesional UTest","2094687","junit@mail.com","123456", "PROFESSIONAL", null,0);
			professionalRepository.saveAndFlush(professional);
			exist = true;
		}
		Assert.assertTrue(exist);
	}

	@Test
	public void getProfessionalByStateTest(){
		List<Professional> professionalList = professionalRepository.getProfessionalsByState(0);
		System.out.println("getProfessionalByStateTest output");
		for (Professional p : professionalList){
			System.out.println(p.getName());
		}
		Assert.assertNotNull(professionalList);
	}

	@Test
	public void getUserIDByEmail(){
		User u = applicationService.traerUsuario("cliente@mail.com");
		System.out.println(u.getId());
		Assert.assertNotNull(u);
	}
}
