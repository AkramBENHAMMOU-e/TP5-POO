-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3307
-- Généré le : sam. 30 nov. 2024 à 22:26
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `prof_dep`
--

-- --------------------------------------------------------

--
-- Structure de la table `departement`
--

CREATE TABLE `departement` (
  `id_depart` int(11) NOT NULL,
  `nom` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `departement`
--

INSERT INTO `departement` (`id_depart`, `nom`) VALUES
(1, 'Informatique'),
(2, 'Mathématiques'),
(6, 'Physique');

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

CREATE TABLE `professeur` (
  `id_prof` int(11) NOT NULL,
  `nom` text NOT NULL,
  `prenom` text NOT NULL,
  `cin` text NOT NULL,
  `adresse` text NOT NULL,
  `telephone` text NOT NULL,
  `email` text NOT NULL,
  `date_recrutement` date NOT NULL,
  `departement_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `professeur`
--

INSERT INTO `professeur` (`id_prof`, `nom`, `prenom`, `cin`, `adresse`, `telephone`, `email`, `date_recrutement`, `departement_id`) VALUES
(1, 'Dupont', 'Jean', 'C123456', '123 Rue A', '0600000001', 'jean.dupont@example.com', '2024-11-30', 1),
(2, 'Martin', 'Claire', 'C234567', '234 Rue B', '0600000002', 'claire.martin@example.com', '2024-11-30', 2),
(3, 'Bernard', 'Louis', 'C345678', '345 Rue C', '0600000003', 'louis.bernard@example.com', '2024-11-30', 3),
(4, 'Petit', 'Marie', 'C456789', '456 Rue D', '0600000004', 'marie.petit@example.com', '2024-11-30', 2),
(5, 'Robert', 'Paul', 'C567890', '567 Rue E', '0600000005', 'paul.robert@example.com', '2024-11-30', 2),
(7, 'Durand', 'Luc', 'C789012', '789 Rue G', '0600000007', 'luc.durand@example.com', '2024-11-30', 3),
(8, 'Leroy', 'Julie', 'C890123', '890 Rue H', '0600000008', 'julie.leroy@example.com', '2024-11-30', 1),
(9, 'Moreau', 'Pierre', 'C901234', '901 Rue I', '0600000009', 'pierre.moreau@example.com', '2024-11-30', 3),
(10, 'Simon', 'Laura', 'C012345', '012 Rue J', '0600000010', 'laura.simon@example.com', '2024-11-30', 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `departement`
--
ALTER TABLE `departement`
  ADD PRIMARY KEY (`id_depart`);

--
-- Index pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD PRIMARY KEY (`id_prof`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `departement`
--
ALTER TABLE `departement`
  MODIFY `id_depart` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `professeur`
--
ALTER TABLE `professeur`
  MODIFY `id_prof` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
