package com.spiderverse.spider.config;

import com.spiderverse.spider.entities.SpiderLocal;
import com.spiderverse.spider.entities.Spiderverse;
import com.spiderverse.spider.entities.User;
import com.spiderverse.spider.entities.Villain;
import com.spiderverse.spider.entities.enums.SpiderSituationStatus;
import com.spiderverse.spider.entities.enums.VillainSituationStatus;
import com.spiderverse.spider.repositories.SpiderverseRepository;
import com.spiderverse.spider.repositories.UserRepository;
import com.spiderverse.spider.repositories.VillainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("verse")
public class SpiderConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SpiderverseRepository spiderRepository;

    @Autowired
    private VillainRepository villainRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Vitor Eduardo", "vitor@gmail.com", "edu2002");
        User user2 = new User(null, "Eduardo", "edu@gmail.com", "12112002");

        Spiderverse spider1 = new Spiderverse(616L, "Peter Parker", "Spider-man", "Spider-man of the earth 616, main universe", Instant.parse("1692-08-01T19:53:07Z"), SpiderSituationStatus.FREE, user1);
        Spiderverse spider2 = new Spiderverse(1610L, "Miles Morales", "Spider-man", "Spider-man of the earth 6160, in ultimate universe", Instant.parse("2011-08-01T08:53:07Z"), SpiderSituationStatus.ON_MISSION, user1);
        Spiderverse spider3 = new Spiderverse(65L, "Gwen Stacy", "Spider-woman", "Spider-woman of the earth 65, in alternative universe", Instant.parse("2014-09-01T10:23:07Z"), SpiderSituationStatus.ON_MISSION, user2);

        Villain villain1 = new Villain(null, "Doctor Otto Gunther Octavius", "Doctor Octavius", "Super-villain of the spider-mans", Instant.parse("2014-09-01T10:23:07Z"), VillainSituationStatus.CAPTURED);
        Villain villain2 = new Villain(null, "Venom", "Venom", "Super-villain of the spider-mans", Instant.parse("2014-09-01T10:23:07Z"), VillainSituationStatus.DEAD);
        Villain villain3 = new Villain(null, "Peter Parker", "Lizard", "Super-villain of the spider-mans", Instant.parse("2014-09-01T10:23:07Z"), VillainSituationStatus.DEAD);
        Villain villain4 = new Villain(null, "Adrian Toomes", "Vulture", "Super-villain of the spider-mans", Instant.parse("2014-09-01T10:23:07Z"), VillainSituationStatus.CAPTURED);

        userRepository.saveAll(Arrays.asList(user1, user2));
        spiderRepository.saveAll(Arrays.asList(spider1, spider2, spider3));
        villainRepository.saveAll(Arrays.asList(villain1, villain2, villain3, villain4));

        spider1.getVillains().add(villain1);
        spider1.getVillains().add(villain2);
        spider2.getVillains().add(villain1);
        spider3.getVillains().add(villain3);
        spider1.getVillains().add(villain4);

        spiderRepository.saveAll(Arrays.asList(spider1, spider2, spider3));

        SpiderLocal spiderLocal1 = new SpiderLocal(null, "New York", "Brooklyn", spider2);
        SpiderLocal spiderLocal2 = new SpiderLocal(null, "New York", "Queens", spider1);
        SpiderLocal spiderLocal3 = new SpiderLocal(null, "New York", "Queens", spider3);

        spider2.setSpiderLocal(spiderLocal1);
        spider1.setSpiderLocal(spiderLocal2);
        spider3.setSpiderLocal(spiderLocal3);

        spiderRepository.saveAll(Arrays.asList(spider1, spider2, spider3));
    }
}
