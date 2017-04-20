package edu.eci.cosw;

import edu.eci.cosw.Interfaz.repositorio.CategoryRepository;
import edu.eci.cosw.Interfaz.repositorio.ServicesRepository;
import edu.eci.cosw.models.Categories;
import edu.eci.cosw.models.Services;
import org.apache.catalina.LifecycleState;
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

	@Test
	public void contextLoads() {
	}

	@Test
	public void getCategoryTest(){
		Categories cat = categoryRepository.findOne(1);
		System.out.println(cat.getName());
		for(Services ser : cat.getServices()){
			System.out.println(ser.getName());
		}
		Assert.assertNotNull(cat);
	}

	@Test
	public void getServicesByCategoryTest(){
		List<Services> services = servicesRepository.getServicesByCategory("Peluqueria");
		Assert.assertNotNull(services);
	}

}
