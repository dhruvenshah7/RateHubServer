# RateHubServer

-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ratehub
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment_master`
--

DROP TABLE IF EXISTS `comment_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment_master` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(200) NOT NULL,
  `rest_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `comment_fk` (`rest_id`),
  CONSTRAINT `comment_fk` FOREIGN KEY (`rest_id`) REFERENCES `restaurant_master` (`rest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_master`
--

LOCK TABLES `comment_master` WRITE;
/*!40000 ALTER TABLE `comment_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dish_category`
--

DROP TABLE IF EXISTS `dish_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dish_category` (
  `dish_cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `dish_category` varchar(200) NOT NULL,
  PRIMARY KEY (`dish_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish_category`
--

LOCK TABLES `dish_category` WRITE;
/*!40000 ALTER TABLE `dish_category` DISABLE KEYS */;
INSERT INTO `dish_category` VALUES (4,'Maincourse'),(5,'Drinks'),(6,'Desserts');
/*!40000 ALTER TABLE `dish_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dish_master`
--

DROP TABLE IF EXISTS `dish_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dish_master` (
  `dish_id` int(11) NOT NULL AUTO_INCREMENT,
  `dish_name` varchar(200) NOT NULL,
  `dish_description` varchar(200) NOT NULL,
  `dish_cat_id` int(11) DEFAULT NULL,
  `rest_id` int(11) DEFAULT NULL,
  `rest_cat_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`dish_id`),
  KEY `user_fk` (`dish_cat_id`),
  KEY `dish_fk` (`rest_id`),
  KEY `rest_cat_id_FK` (`rest_cat_id`),
  CONSTRAINT `dish_fk` FOREIGN KEY (`rest_id`) REFERENCES `restaurant_master` (`rest_id`),
  CONSTRAINT `rest_cat_id_FK` FOREIGN KEY (`rest_cat_id`) REFERENCES `restaurant_category` (`rest_cat_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`dish_cat_id`) REFERENCES `dish_category` (`dish_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish_master`
--

LOCK TABLES `dish_master` WRITE;
/*!40000 ALTER TABLE `dish_master` DISABLE KEYS */;
INSERT INTO `dish_master` VALUES (4,'Salmon',' Classified as an oily fish, salmon is considered to be healthy due to the fishs high protein, high omega fatty acids, and high vitamin D content.',4,10,1),(5,'California Hand Roll',' Hand roll sushi is a very popular sushi dish in Japanese home cooking. You need Sushi Rice and sheets of roasted seaweed',4,10,1),(6,'Beef Gyoza','The most prominent differences between Japanese-style gyōza and Chinese-style jiaozi are the rich garlic flavor, which is less noticeable in the Chinese version',4,10,1),(7,'Dynamite Roll','Dynamite roll is a type of Western-style sushi. It is common in Western Canada.',4,10,2),(8,'Assorted Seafood Fried Noodle','Chinese pan fried noodles, topped with stir fried seafood and vegetables.',4,10,2),(9,'Spicy White Tuna',' Fiery spicy tuna roll with sashimi grade tuna tossed in a sesame ...',4,10,2),(10,'Fried Chicken Cutlet','a thin slice of meat from the leg or ribs of veal, pork, or mutton',4,10,3),(11,'Philadelphia roll','A Philadelphia roll is a makizushi type of sushi generally made with smoked salmon, cream cheese, and cucumber',4,10,3),(12,'Mango Cucumber Hand Roll','Futomaki are often vegetarian, and may utilize strips of cucumber',4,10,3),(13,'Ice Wine',' Ice wine (or icewine; German Eiswein) is a type of dessert wine produced from grapes that have been frozen while still on the vine.',5,10,3),(14,'Ice Wine',' Ice wine (or icewine; German Eiswein) is a type of dessert wine produced from grapes that have been frozen while still on the vine.',5,10,3),(15,'Beer','Beer is an alcoholic beverage produced by fermentation.[1] Most beer is flavoured with hops, which add bitterness and act as a natural preservative.',5,10,3),(16,'Ice Wine',' Ice wine (or icewine; German Eiswein) is a type of dessert wine produced from grapes that have been frozen while still on the vine.',5,10,1),(17,'Beer','Beer is an alcoholic beverage produced by fermentation.[1] Most beer is flavoured with hops, which add bitterness and act as a natural preservative.',5,10,1),(18,'Chocolate Cake',' Chocolate cake is a cake flavored with melted chocolate and/or cocoa powder.',6,10,1),(19,'Mango Ice-cream',' The \"Ice Cream\" mango is a semi-dwarf mango cultivar.',6,10,1),(20,'Ice Wine',' Ice wine (or icewine; German Eiswein) is a type of dessert wine produced from grapes that have been frozen while still on the vine.',5,10,2),(21,'Beer','Beer is an alcoholic beverage produced by fermentation.[1] Most beer is flavoured with hops, which add bitterness and act as a natural preservative.',5,10,3),(22,'Raspberry mousse','Raspberry mousse in shallow cups, garnished with ground cinnamon.',6,10,2),(23,'Green Tea Ice-cream','Green tea ice cream or matcha ice is a Japanese ice cream flavor.',6,10,2),(24,'Chocolate mousse','Chocolate mousse in shallow cups, garnished with ground cinnamon.',6,10,3),(25,'Gulab Jamun','Gulaab jamun, is a milk-solids-based sweet mithai, popular in countries of South Asia and found in such as Indian cuisine.',6,10,3),(26,'Escargot',' The escargot is a cooked land snail.',4,11,1),(27,'Traditional Mussel Provençale',' A traditional Mussel Provençale from Marseille, with the fish served separately after the soup',4,11,1),(28,'Beef Gyoza','The most prominent differences between Japanese-style gyōza and Chinese-style jiaozi are the rich garlic flavor, which is less noticeable in the Chinese version',4,11,1),(29,'Ice Wine',' Ice wine (or icewine; German Eiswein) is a type of dessert wine produced from grapes that have been frozen while still on the vine.',5,11,1),(30,'Beer','Beer is an alcoholic beverage produced by fermentation.[1] Most beer is flavoured with hops, which add bitterness and act as a natural preservative.',5,11,1),(31,'Chocolate Cake',' Chocolate cake is a cake flavored with melted chocolate and/or cocoa powder.',6,11,1),(32,'Mango Ice-cream',' The \"Ice Cream\" mango is a semi-dwarf mango cultivar.',6,11,1),(33,'Butterfly Coconut Shrimp','Peeled and deveined shrimp with the shell left on the last (tail) segment.',4,11,2),(34,'Crisp Torpedo Shrimp & Golden Crisp Calamari','Golden Crisp is a breakfast cereal made by Post Cereals which consists of sweetened, candy-coated puffed wheat.',4,11,2),(35,'Assorted Seafood Fried Noodle','Chinese pan fried noodles, topped with stir fried seafood and vegetables.',4,11,2),(36,'Beer','Beer is an alcoholic beverage produced by fermentation.[1] Most beer is flavoured with hops, which add bitterness and act as a natural preservative.',5,10,2),(37,'Ice Wine',' Ice wine (or icewine; German Eiswein) is a type of dessert wine produced from grapes that have been frozen while still on the vine.',5,11,2),(38,'Beer','Beer is an alcoholic beverage produced by fermentation.[1] Most beer is flavoured with hops, which add bitterness and act as a natural preservative.',5,11,2),(39,'Raspberry mousse','Raspberry mousse in shallow cups, garnished with ground cinnamon.',6,11,2),(40,'Green Tea Ice-cream','Green tea ice cream or matcha ice is a Japanese ice cream flavor.',6,11,2),(41,'French Rack of Lamb','this is a whole roasting joint consisting of six-eight cutlets. A single guard of honor is ideal for two persons',4,11,3),(42,'Fillet Mignon','Filet mignon is a steak cut of beef taken from the smaller end of the tenderloin, or psoas major of the beef carcass',4,11,3),(43,'Mango Cucumber Hand Roll','Futomaki are often vegetarian, and may utilize strips of cucumber',4,11,3),(44,'Ice Wine',' Ice wine (or icewine; German Eiswein) is a type of dessert wine produced from grapes that have been frozen while still on the vine.',5,11,3),(45,'Beer','Beer is an alcoholic beverage produced by fermentation.[1] Most beer is flavoured with hops, which add bitterness and act as a natural preservative.',5,11,3),(46,'Chocolate mousse','Chocolate mousse in shallow cups, garnished with ground cinnamon.',6,11,3),(47,'Gulab Jamun','Gulaab jamun, is a milk-solids-based sweet mithai, popular in countries of South Asia and found in such as Indian cuisine.',6,11,3),(48,'Red Wine',' Ice wine (or icewine; German Eiswein) is a type of dessert wine produced from grapes that have been frozen while still on the vine.',5,12,2),(49,'Molson Beer','Beer is an alcoholic beverage produced by fermentation.[1] Most beer is flavoured with hops, which add bitterness and act as a natural preservative.',5,12,2),(50,'Ras Malai','cottage cheese balls soaked in thickened, sweetened and flavored milk.',6,12,2),(51,'Gulab Jamun','Gulaab jamun, is a milk-solids-based sweet mithai, popular in countries of South Asia and found in such as Indian cuisine.',6,12,2),(52,'Chana Masala',' It is fairly dry and spicy with a sour citrus note',4,12,3),(53,'Dal Makhni','The primary ingredients in dal makhani are whole black lentil with red kidney beans, butter and cream',4,12,3),(54,'Shahi Korma','Korma is a mild, creamy curry thickened with ground nuts and with origins in the Mughlai ',4,12,3),(55,'White Wine',' Ice wine (or icewine; German Eiswein) is a type of dessert wine produced from grapes that have been frozen while still on the vine.',5,12,3),(56,'Budweiser Beer','Beer is an alcoholic beverage produced by fermentation.[1] Most beer is flavoured with hops, which add bitterness and act as a natural preservative.',5,12,3),(57,'Mango Smoothie','Mangos and bananas are blended with milk and yogurt.',6,12,3),(58,'Mango Juice','Fresh Mango Juice. Summer is one of the only times when one can enjoy the true ecstasy of fresh mango juice.',6,12,3),(59,'Quiche','Quiche is a savoury, open-faced pastry crust with a filling of savoury custard with cheese, meat, seafood, and/or vegetables.',4,13,2),(60,'Chicken Pot Pie','A pot pie is a type of meat pie with a top crust, generally made of flaky pastry.',4,13,2),(61,'Vegetarian Lasagna','Lasagna are wide, flat-shaped pasta, and possibly one of the oldest types of pasta.',4,13,2),(62,'Hot Wine',' Ice wine (or icewine; German Eiswein) is a type of dessert wine produced from grapes that have been frozen while still on the vine.',5,13,2),(63,'Budlight Beer','Beer is an alcoholic beverage produced by fermentation.[1] Most beer is flavoured with hops, which add bitterness and act as a natural preservative.',5,13,2),(64,'Hot Sticky Buns','Cinnamon sweet sticky buns, with melted brown sugar and pecans..',6,13,2),(65,'New York Cheese Cake',' Once chilled, this cake can be covered with plastic wrap and refrigerated for up to three day.',6,13,2),(66,'Chicken Supreme','The term supreme used in cooking and culinary arts refers to the best part of the food',4,13,3),(67,'Atlantic Salmon','The Atlantic salmon is a salmon in the family Salmonidae',4,13,3),(68,'Duck Breast','Duck meat is derived primarily from the breasts and legs of ducks ',4,13,3),(69,'Sparkling Wine','Sparkling wine is a wine with significant levels of carbon dioxide in it, making it fizzy.',5,13,3),(70,'Corona Beer','Beer is an alcoholic beverage produced by fermentation.Most beer is flavoured with hops, which add bitterness and act as a natural preservative.',5,13,3),(71,'Brownies & Ice-cream','Homemade chocolate ice cream and fudgy brownie bites are perfect companions in this recipe combo.',6,13,3),(72,'Vanilla Ice-cream','Vanilla is frequently used to flavor ice cream, especially in North America and Europe.',6,13,3),(73,'Chicken Souvlaki','This Chicken Souvlaki recipe is a flavourful must-have main for any Greek-inspired menu.',4,14,1),(74,'Fried Chicken','Fried chicken is a dish consisting of chicken pieces usually from broiler chickens',4,14,1),(75,'Liver and onions','Liver and onions is a dish consisting of slices of liver and onions',4,14,1),(76,'Whiskey','Whisky or whiskey is a type of distilled alcoholic beverage made from fermented grain mash.',5,14,1),(77,'Breezer','is a fruit–based alcopop with 4.4% alcohol in Australia, 4%/5% Canada.',5,14,1),(78,'Rice Pudding','Rice pudding is a dish made from rice mixed with water or milk and other ingredients such as cinnamon and raisins.',6,14,1),(79,'Mango Ice-cream','Lemon meringue pie is a type of baked pie, usually served for dessert, made with a crust usually made of shortcrust pastry, lemon custard filling and a fluffy meringue topping.',6,14,1),(80,'Spaghetti & Meat Sauce','consisting in spaghetti served with a ground meat sauce..',4,14,2),(81,'BBQ Ribs','These ribs are seasoned, boiled until tender, then baked with your favorite barbeque sauce.',4,14,2),(82,'Lemon Tilapia','Tilapia fillets are bathed in lemon juice and melted butter, seasoned with garlic and parsley, and baked to flaky perfection..',4,14,2),(83,'Mulled wine','Mulled wine is a beverage of European origins usually made with red wine along with various mulling spices and sometimes raisins.',5,14,2),(84,'Clamato Juice','Clamato /kləˈmɑːtoʊ/ is a drink made of reconstituted tomato juice concentrate, flavored with spices and clam broth.',5,14,2),(85,'Butter Tarts','A butter tart is a type of small pastry tart highly regarded in Canadian cuisine and considered one of Canadas quintessential desserts.',6,14,2),(86,'Baklava','Baklava is a rich, sweet pastry made of layers of filo filled with chopped nuts and sweetened and held together with syrup or honey.',6,14,2),(87,'Smothered Chicken','A plate lunch of smothered steak and gravy served over boiled white rice and chicken',4,14,3),(88,'Kid’s Bacon & Egg','Kids can use their favorite cookie cutter shapes to make this hearty dinner with a grilled cheese-like twist',4,14,3),(89,'Single Pork Chop Dinner','A beef steak dinner, served with roasted eggplant, zucchini and garlic ... In a larger sense, there are also fish steaks, ground meat steaks, pork steak and many',4,14,3),(90,'Rose Wine','A rosé is a type of wine that incorporates some of the color from the grape skins, but not enough to qualify it as a red wine.',5,14,3),(91,'Champagne','Champagne is a sparkling wine produced from the Champagne region grape grown in France following rules that demand.',5,14,3);
/*!40000 ALTER TABLE `dish_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_master`
--

DROP TABLE IF EXISTS `location_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_master` (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `longitude` varchar(200) NOT NULL,
  `latitude` varchar(200) NOT NULL,
  `rest_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`location_id`),
  KEY `loc_fk` (`rest_id`),
  CONSTRAINT `loc_fk` FOREIGN KEY (`rest_id`) REFERENCES `restaurant_master` (`rest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_master`
--

LOCK TABLES `location_master` WRITE;
/*!40000 ALTER TABLE `location_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating_master`
--

DROP TABLE IF EXISTS `rating_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rating_master` (
  `rate_id` int(11) NOT NULL AUTO_INCREMENT,
  `rating` decimal(5,2) NOT NULL,
  `dish_id` int(11) DEFAULT NULL,
  `rest_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`rate_id`),
  KEY `dish_id` (`dish_id`),
  KEY `rest_id` (`rest_id`),
  CONSTRAINT `rating_master_ibfk_1` FOREIGN KEY (`dish_id`) REFERENCES `dish_master` (`dish_id`),
  CONSTRAINT `rating_master_ibfk_2` FOREIGN KEY (`rest_id`) REFERENCES `restaurant_master` (`rest_id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating_master`
--

LOCK TABLES `rating_master` WRITE;
/*!40000 ALTER TABLE `rating_master` DISABLE KEYS */;
INSERT INTO `rating_master` VALUES (1,2.50,4,10),(2,4.00,5,10),(3,3.00,6,10),(4,3.50,7,10),(5,4.50,8,10),(6,2.50,9,10),(7,3.00,10,10),(8,2.00,11,10),(9,3.50,12,10),(10,2.00,13,10),(11,4.50,14,10),(12,3.00,15,10),(13,2.50,16,10),(14,3.50,17,10),(15,2.00,18,10),(16,4.00,19,10),(17,2.00,20,10),(18,2.50,21,10),(19,3.00,22,10),(20,2.00,23,10),(21,3.50,24,10),(22,3.00,25,10),(23,3.00,26,11),(24,2.00,27,11),(25,3.50,28,11),(26,2.50,29,11),(27,3.00,30,11),(28,3.50,31,11),(29,2.00,32,11),(30,2.50,33,11),(31,4.00,34,11),(32,3.50,35,11),(33,2.00,36,10),(34,1.50,37,11),(35,3.00,38,11),(36,3.50,39,11),(37,1.00,40,11),(38,4.00,41,11),(39,2.00,42,11),(40,3.50,43,11),(41,4.50,44,11),(42,3.00,45,11),(43,2.50,46,11),(44,3.00,47,11),(45,3.00,48,12),(46,3.50,49,12),(47,2.50,50,12),(48,4.00,51,12),(49,3.50,52,12),(50,2.00,53,12),(51,3.00,54,12),(52,1.50,55,12),(53,4.00,56,12),(54,2.00,57,12),(55,1.50,58,12),(56,3.00,59,13),(57,2.00,60,13),(58,2.50,61,13),(59,1.50,62,13),(60,3.50,63,13),(61,2.00,64,13),(62,4.00,65,13),(63,1.00,66,13),(64,4.50,67,13),(65,2.00,68,13),(66,2.50,69,13),(67,1.00,70,13),(68,2.00,71,13),(69,3.50,72,13),(70,3.50,73,14),(71,3.00,74,14),(72,2.00,75,14),(73,4.00,76,14),(74,2.50,77,14),(75,3.00,78,14),(76,3.50,79,14),(77,2.00,80,14),(78,2.50,81,14),(79,4.50,82,14),(80,2.00,83,14),(81,1.50,84,14),(82,1.00,85,14),(83,2.50,86,14),(84,3.50,87,14),(85,1.50,88,14),(86,2.00,89,14),(87,3.00,90,14),(88,3.50,91,14);
/*!40000 ALTER TABLE `rating_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rest_restcat`
--

DROP TABLE IF EXISTS `rest_restcat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rest_restcat` (
  `rest_restcat_id` int(11) NOT NULL AUTO_INCREMENT,
  `rest_id` int(11) DEFAULT NULL,
  `rest_cat_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`rest_restcat_id`),
  KEY `rest_id` (`rest_id`),
  KEY `rest_cat_id` (`rest_cat_id`),
  CONSTRAINT `rest_restcat_ibfk_1` FOREIGN KEY (`rest_id`) REFERENCES `restaurant_master` (`rest_id`),
  CONSTRAINT `rest_restcat_ibfk_2` FOREIGN KEY (`rest_cat_id`) REFERENCES `restaurant_category` (`rest_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rest_restcat`
--

LOCK TABLES `rest_restcat` WRITE;
/*!40000 ALTER TABLE `rest_restcat` DISABLE KEYS */;
INSERT INTO `rest_restcat` VALUES (1,10,1),(2,10,2),(3,10,3),(4,11,1),(5,11,2),(6,11,3),(7,12,2),(8,12,3),(9,13,2),(10,13,3),(11,14,1),(12,14,2),(13,14,3);
/*!40000 ALTER TABLE `rest_restcat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_category`
--

DROP TABLE IF EXISTS `restaurant_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_category` (
  `rest_cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `rest_category` varchar(200) NOT NULL,
  PRIMARY KEY (`rest_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_category`
--

LOCK TABLES `restaurant_category` WRITE;
/*!40000 ALTER TABLE `restaurant_category` DISABLE KEYS */;
INSERT INTO `restaurant_category` VALUES (1,'Brunch'),(2,'Lunch'),(3,'Dinner');
/*!40000 ALTER TABLE `restaurant_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_master`
--

DROP TABLE IF EXISTS `restaurant_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_master` (
  `rest_id` int(11) NOT NULL AUTO_INCREMENT,
  `rest_name` varchar(200) NOT NULL,
  `street` varchar(200) NOT NULL,
  `city` varchar(200) NOT NULL,
  `province` varchar(200) NOT NULL,
  `postal_code` varchar(10) NOT NULL,
  PRIMARY KEY (`rest_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_master`
--

LOCK TABLES `restaurant_master` WRITE;
/*!40000 ALTER TABLE `restaurant_master` DISABLE KEYS */;
INSERT INTO `restaurant_master` VALUES (10,'Hana Japanese Restaurant','Capel Street','Sarnia','Ontario','N7T 6T6'),(11,'Maison St-Aubin','Devine Street','Sarnia','Ontario','N4T 5T6'),(12,'Sitara Indian Cuisine','Indian Street','Sarnia','Ontario','N7T 6T6'),(13,'Olives Casual Cuisine','London Line','Sarnia','Ontario','N7T 7H2'),(14,'Johns Restaurant','London Street','Sarnia','Ontario','N7W 1A9'),(15,'Big Fish','London Street','Sarnia','Ontario','N7W 1A9'),(16,'Cosmos Tavern','London Street','Sarnia','Ontario','N7W 1A9'),(17,'Silicy Restaurant & Pizzeria','London Street','Sarnia','Ontario','N7W 1A9'),(18,'Victory Buffet','London Street','Sarnia','Ontario','N7W 1A9'),(19,'Lizards Bar & Grill','London Street','Sarnia','Ontario','N7W 1A9');
/*!40000 ALTER TABLE `restaurant_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_master`
--

DROP TABLE IF EXISTS `user_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_master` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(200) NOT NULL,
  `last_name` varchar(200) NOT NULL,
  `email_id` varchar(40) DEFAULT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_id` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_master`
--

LOCK TABLES `user_master` WRITE;
/*!40000 ALTER TABLE `user_master` DISABLE KEYS */;
INSERT INTO `user_master` VALUES (1,'nirat','joshi','nirat.joshi32@gmail.com','niratjoshi'),(2,'dhruven','shah','dhruven.shah@gmail.com','dhruvenshah'),(3,'rohan','parekh','rohan.parekh@gmail.com','rohanparekh'),(4,'mihir','modha','mihir.modha@gmail.com','mihirmodha'),(5,'parth','pandya','parth.pandya@gmail.com','parthpandya');
/*!40000 ALTER TABLE `user_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-18 15:03:45
