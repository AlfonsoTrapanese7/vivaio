-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 09, 2025 alle 15:16
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vivaio`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `accessory`
--

CREATE TABLE `accessory` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `price` double NOT NULL,
  `description` varchar(200) NOT NULL,
  `color` varchar(30) DEFAULT NULL,
  `photo` longtext DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `date_of_restock` date DEFAULT NULL,
  `size` varchar(50) NOT NULL,
  `brand` varchar(30) NOT NULL,
  `material` varchar(30) DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL,
  `id_category` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `accessory`
--

INSERT INTO `accessory` (`id`, `name`, `price`, `description`, `color`, `photo`, `quantity`, `date_of_restock`, `size`, `brand`, `material`, `is_active`, `id_category`) VALUES
(1, 'Garden Shovel', 15, 'A durable metal shovel for gardening tasks.', 'Silver', NULL, 50, '2025-06-01', 'Medium', 'Gardena', 'Steel', 1, 1),
(2, 'Watering Can', 10, 'A plastic watering can for easy watering.', 'Green', NULL, 70, '2025-06-02', 'Large', 'Bosch', 'Plastic', 1, 2),
(3, 'Flower Pots', 5, 'A set of 3 flower pots for planting small plants.', 'Terracotta', NULL, 100, '2025-06-05', 'Small', 'Cotto', 'Clay', 1, 3),
(4, 'Plant Stand', 25, 'A decorative plant stand for displaying your plants.', 'Wooden', NULL, 30, '2025-06-10', 'Medium', 'Ikea', 'Wood', 1, 9),
(5, 'Garden Gloves', 8, 'Protective gloves for gardening work.', 'Green', NULL, 60, '2025-06-12', 'One Size', 'Husqvarna', 'Cotton', 1, 1),
(6, 'Lawn Mower', 120, 'Electric lawn mower for maintaining your garden.', 'Red', NULL, 10, '2025-06-15', 'Large', 'Stihl', 'Metal', 1, 1),
(7, 'Hose Reel', 30, 'A hose reel for easy storage and use of garden hoses.', 'Black', NULL, 40, '2025-06-18', 'Medium', 'Karcher', 'Plastic', 1, 2),
(8, 'Plant Fertilizer', 12, 'Organic fertilizer for healthy plant growth.', NULL, NULL, 150, '2025-06-20', 'One Size', 'Miracle-Gro', 'Organic', 1, 4),
(9, 'Garden Pruner', 20, 'A hand-held pruner for trimming plants and trees.', 'Silver', NULL, 35, '2025-06-25', 'Medium', 'Fiskars', 'Steel', 1, 1),
(10, 'Plant Watering System', 40, 'Automatic watering system for easy irrigation.', 'White', NULL, 25, '2025-06-28', 'Large', 'Rain Bird', 'Plastic', 1, 2),
(11, 'Garden Kneeling Pad', 15, 'A foam kneeling pad for comfortable gardening.', 'Blue', NULL, 55, '2025-06-30', 'One Size', 'Garden Mate', 'Foam', 1, 1),
(12, 'Garden Tool Set', 22, 'A set of essential tools for gardening tasks.', 'Red', NULL, 45, '2025-07-02', 'One Size', 'Husqvarna', 'Steel', 1, 1),
(13, 'Garden Sprayer', 12, 'A hand sprayer for applying pesticides or fertilizers.', 'White', NULL, 100, '2025-07-22', 'Medium', 'Karcher', 'Plastic', 1, 8),
(14, 'Outdoor Bench', 80, 'A comfortable bench for outdoor relaxation.', 'Brown', NULL, 20, '2025-07-08', 'Large', 'Ikea', 'Wood', 1, 7),
(15, 'Garden Hose', 25, 'A 30-meter garden hose for watering plants.', 'Green', NULL, 50, '2025-07-10', 'Large', 'Gardena', 'Rubber', 1, 2),
(16, 'Garden Scissors', 12, 'Sharp scissors for trimming small plants.', 'Silver', NULL, 40, '2025-07-12', 'Medium', 'Bosch', 'Steel', 1, 1),
(17, 'Patio Umbrella', 60, 'A large umbrella for shading outdoor areas.', 'Red', NULL, 30, '2025-07-15', 'Large', 'Outsunny', 'Fabric', 1, 5),
(18, 'Garden Rake', 18, 'A rake for collecting leaves and debris in the garden.', 'Silver', NULL, 45, '2025-07-18', 'Medium', 'Bosch', 'Steel', 1, 1),
(19, 'Outdoor Table', 50, 'A durable table for outdoor dining.', 'Brown', NULL, 25, '2025-07-20', 'Large', 'Ikea', 'Wood', 1, 5);

-- --------------------------------------------------------

--
-- Struttura della tabella `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(30) NOT NULL,
  `pword` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `admin`
--

INSERT INTO `admin` (`id`, `name`, `surname`, `email`, `username`, `pword`) VALUES
(1, 'John', 'Doe', 'johndoe@example.com', 'johndoe', 'password123');

-- --------------------------------------------------------

--
-- Struttura della tabella `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `accessory_category` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `category`
--

INSERT INTO `category` (`id`, `accessory_category`) VALUES
(1, 'Gardening Tools'),
(2, 'Irrigation'),
(3, 'Pots and Containers'),
(4, 'Fertilizers'),
(5, 'Mulch'),
(6, 'Covers and Tarps'),
(7, 'Garden Decorations'),
(8, 'Pest Control Products'),
(9, 'Plant Supports'),
(10, 'Outdoor Lighting');

-- --------------------------------------------------------

--
-- Struttura della tabella `location`
--

CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `plant_location` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `location`
--

INSERT INTO `location` (`id`, `plant_location`) VALUES
(1, 'Outdoor'),
(2, 'Indoor'),
(3, 'Greenhouse'),
(4, 'Indoor and outdoor');

-- --------------------------------------------------------

--
-- Struttura della tabella `nursery`
--

CREATE TABLE `nursery` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `price` double NOT NULL,
  `description` varchar(200) NOT NULL,
  `color` varchar(30) DEFAULT NULL,
  `photo` longtext DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `date_of_restock` date DEFAULT NULL,
  `origin` varchar(30) NOT NULL,
  `season` varchar(30) NOT NULL,
  `watering` varchar(30) DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL,
  `id_type` int(11) NOT NULL,
  `id_location` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `nursery`
--

INSERT INTO `nursery` (`id`, `name`, `price`, `description`, `color`, `photo`, `quantity`, `date_of_restock`, `origin`, `season`, `watering`, `is_active`, `id_type`, `id_location`) VALUES
(22, 'Apple Tree', 40, 'A fruit-bearing tree producing sweet apples.', NULL, NULL, 30, '2025-06-01', 'USA', 'Spring', 'Moderate', 1, 2, 1),
(23, 'Rose Bush', 25.5, 'A vibrant flowering bush with red roses.', 'Red', NULL, 50, '2025-06-01', 'Italy', 'Spring', 'Regular', 1, 1, 3),
(24, 'Tomato Plant', 7, 'An edible plant for growing tomatoes.', 'Green', NULL, 120, '2025-06-05', 'Spain', 'Summer', 'High', 1, 5, 2),
(25, 'Basil Plant', 6.5, 'A fragrant herb perfect for cooking.', 'Green', NULL, 150, '2025-06-10', 'Italy', 'Summer', 'Regular', 1, 5, 4),
(26, 'Cucumber Plant', 9, 'A fast-growing vegetable plant for the garden.', 'Green', NULL, 80, '2025-06-08', 'France', 'Summer', 'High', 1, 5, 2),
(27, 'Lavender Plant', 15.5, 'A fragrant herb plant perfect for gardens.', 'Purple', NULL, 60, '2025-06-12', 'France', 'Spring', 'Moderate', 1, 5, 3),
(28, 'Aloe Vera', 12.5, 'A medicinal succulent plant known for its gel.', 'Green', NULL, 100, '2025-06-15', 'South Africa', 'Summer', 'Low', 1, 5, 1),
(29, 'Lemon Tree', 45, 'A fruit-bearing tree that produces lemons.', NULL, NULL, 25, '2025-06-18', 'Spain', 'Winter', 'Moderate', 1, 2, 4),
(30, 'Tulip Bulbs', 12, 'Colorful tulip bulbs for spring flowers.', 'Multicolor', NULL, 200, '2025-06-20', 'Netherlands', 'Spring', 'Low', 1, 1, 3),
(31, 'Cactus', 18, 'Small cactus ideal for indoor decoration.', 'Green', NULL, 150, '2025-06-22', 'Mexico', 'Summer', 'Low', 1, 5, 1),
(32, 'Fuchsia Plant', 20, 'A colorful plant with drooping flowers.', 'Pink', NULL, 60, '2025-06-25', 'Germany', 'Summer', 'Moderate', 1, 1, 2),
(33, 'Pine Tree', 30, 'A fast-growing evergreen tree.', NULL, NULL, 40, '2025-06-28', 'Canada', 'Winter', 'Moderate', 1, 2, 4),
(34, 'Bonsai Tree', 50, 'A small indoor tree for decoration.', NULL, NULL, 30, '2025-07-01', 'Japan', 'Spring', 'Low', 1, 2, 1),
(35, 'Hydrangea Bush', 28, 'A beautiful shrub with blue and pink flowers.', 'Blue', NULL, 45, '2025-07-05', 'Japan', 'Summer', 'Regular', 1, 1, 3),
(36, 'Rosemary Plant', 10.5, 'A fragrant herb perfect for cooking.', 'Green', NULL, 80, '2025-07-08', 'Italy', 'Summer', 'Moderate', 1, 5, 4),
(37, 'Sunflower Seeds', 5, 'Seeds for growing tall and bright sunflowers.', 'Yellow', NULL, 200, '2025-07-10', 'USA', 'Summer', 'High', 1, 3, 2),
(38, 'Ferns', 12, 'A lush plant for shady areas.', 'Green', NULL, 70, '2025-07-12', 'Brazil', 'Spring', 'Moderate', 1, 5, 3),
(39, 'Ficus Tree', 55, 'A popular indoor tree with glossy leaves.', NULL, NULL, 20, '2025-07-15', 'Brazil', 'Winter', 'Moderate', 1, 2, 1),
(40, 'Peony Plant', 18, 'A flowering plant with large, colorful blooms.', 'Pink', NULL, 90, '2025-07-18', 'China', 'Spring', 'Moderate', 1, 1, 4),
(41, 'Daffodil Bulbs', 8, 'Spring-blooming bulbs with yellow flowers.', 'Yellow', NULL, 150, '2025-07-20', 'Netherlands', 'Spring', 'Low', 1, 1, 3),
(42, 'Begonias', 15, 'A beautiful flowering plant with vibrant colors, ideal for both indoor and outdoor settings.', 'Pink', NULL, 80, '2025-07-25', 'China', 'Spring', 'Regular', 1, 1, 4);

-- --------------------------------------------------------

--
-- Struttura della tabella `type`
--

CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `plant_type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `type`
--

INSERT INTO `type` (`id`, `plant_type`) VALUES
(1, 'Flowers'),
(2, 'Trees'),
(3, 'Seeds'),
(4, 'Blooms'),
(5, 'Plants');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `accessory`
--
ALTER TABLE `accessory`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_category` (`id_category`);

--
-- Indici per le tabelle `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `nursery`
--
ALTER TABLE `nursery`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_type` (`id_type`),
  ADD KEY `id_location` (`id_location`);

--
-- Indici per le tabelle `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `accessory`
--
ALTER TABLE `accessory`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT per la tabella `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la tabella `location`
--
ALTER TABLE `location`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `nursery`
--
ALTER TABLE `nursery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT per la tabella `type`
--
ALTER TABLE `type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `accessory`
--
ALTER TABLE `accessory`
  ADD CONSTRAINT `accessory_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`);

--
-- Limiti per la tabella `nursery`
--
ALTER TABLE `nursery`
  ADD CONSTRAINT `nursery_ibfk_1` FOREIGN KEY (`id_type`) REFERENCES `type` (`id`),
  ADD CONSTRAINT `nursery_ibfk_2` FOREIGN KEY (`id_location`) REFERENCES `location` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
