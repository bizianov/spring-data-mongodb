package mongo;

import com.example.model.Person;
import com.example.model.Project;
import com.example.model.Technology;
import com.example.repo.PersonRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * Created by slava23 on 2/9/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestMongoConfig.class})
public class TestMongo {

    private static final Logger LOG = LoggerFactory.getLogger(TestMongo.class);

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void setUp() {
        Technology technology1 = new Technology("Java-7");
        Technology technology2 = new Technology("Java-8");
        Technology technology3 = new Technology("Hibernate");
        Technology technology4 = new Technology("MyBatis");
        Technology technology5 = new Technology("Spring Data");

        Project project1 = new Project(1, "POINT", Arrays.asList(technology1, technology3));
        Project project2 = new Project(2, "Forecast", Arrays.asList(technology1, technology4));
        Project project3 = new Project(3, "CPM", Arrays.asList(technology2, technology5));

        Person person1 = new Person(1, "Alex", 27, Arrays.asList(project1, project3));
        Person person2 = new Person(2, "Ivan", 26, Arrays.asList(project2, project3));
        Person person3 = new Person(3, "Andrii", 31, Arrays.asList(project1));

        personRepository.save(Arrays.asList(person1, person2, person3));
    }

    @Test
    public void count() {
        List<Person> all = personRepository.findAll();
        LOG.info("There are " + all.size() + " person(s) in database");
        assertThat(all.size(), equalTo(3));
    }

    @Test
    public void findByName() {
        List<Person> personList = personRepository.findByName("Ivan");
        LOG.info("*******Find by name********");
        LOG.info("personList {}", personList);
        LOG.info("***************************");
        assertThat(personList, hasSize(1));
    }

    @Test
    public void findByProject() {
        List<Person> personList = personRepository.findByProjectsName("POINT");
        LOG.info("****Find by project name****");
        LOG.info("personList {}", personList);
        LOG.info("****************************");
        assertThat(personList, hasSize(2));
    }

    @Test
    public void findByProjectLike() {
        List<Person> personList = personRepository.findByProjectsNameEndingWith("st");
        LOG.info("****Find by project name like****");
        LOG.info("personList {}", personList);
        LOG.info("****************************");
        assertThat(personList, hasSize(1));
    }

    @Test
    public void findByTechnology() {
        List<Person> personList = personRepository.findByProjectsTechnologiesName("Java-8");
        LOG.info("****Find by technology name****");
        LOG.info("personList {}", personList);
        LOG.info("*******************************");
        assertThat(personList, hasSize(2));
    }

    @Test
    public void findByTechnologyLike() {
        List<Person> personList = personRepository.findByProjectsTechnologiesNameLike(".*Java.*");
        LOG.info("****Find by technology name like****");
        LOG.info("personList {}", personList);
        LOG.info("*************************************");
        assertThat(personList, hasSize(3));
    }

    @Test
    public void findByNameLike() {
        List<Person> byNameLike = personRepository.findByNameLike(".*A.*");
        LOG.info("****Find by name like****");
        byNameLike.stream().map(person -> person.getName()).forEach(System.out::println);
        LOG.info("*******************************");
        assertThat(byNameLike, hasSize(2));
    }

    @After
    public void shutDown() {
        personRepository.deleteAll();
    }
}
