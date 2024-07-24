-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2024. Júl 24. 21:19
-- Kiszolgáló verziója: 10.4.22-MariaDB
-- PHP verzió: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `szakdolgozatok`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `adminisztrator`
--

CREATE TABLE `adminisztrator` (
  `egyetemiAzonosito` char(6) COLLATE utf8_hungarian_ci NOT NULL,
  `munkakoriBeosztas` varchar(17) COLLATE utf8_hungarian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `adminisztrator`
--

INSERT INTO `adminisztrator` (`egyetemiAzonosito`, `munkakoriBeosztas`) VALUES
('AAAAAA', 'oktatásszervező');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `dolgozat`
--

CREATE TABLE `dolgozat` (
  `dolgozatAzonosito` int(11) NOT NULL,
  `cim` varchar(150) COLLATE utf8_hungarian_ci NOT NULL,
  `beadasEve` char(11) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `vedesEve` char(11) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `vedesErdemjegye` tinyint(4) DEFAULT NULL,
  `egyetemiAzonosito` char(6) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `szakAzonosito` varchar(25) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `tanszekNev` varchar(100) COLLATE utf8_hungarian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `dolgozat`
--

INSERT INTO `dolgozat` (`dolgozatAzonosito`, `cim`, `beadasEve`, `vedesEve`, `vedesErdemjegye`, `egyetemiAzonosito`, `szakAzonosito`, `tanszekNev`) VALUES
(11, 'Java programozás', '2021/2022/1', '2021/2022/1', 4, 'FNJOSN', 'BSZKPTI', 'Szoftverfejlesztés Tanszék'),
(12, 'C++ programozás', '2023/2024/1', '2023/2024/1', 4, 'FNJOSN', 'BSZKMEI', 'Szoftverfejlesztés Tanszék'),
(15, 'Fuzzy elmélet alkalmazása lekérdezéseknél', '2023/2024/1', '2023/2024/1', 5, 'HSEHSE', 'BSZKUFO', 'Szoftverfejlesztés Tanszék'),
(16, 'Bevásárlós alkalmazás', '2018/2019/2', '2018/2019/2', 3, 'KGHAGK', 'BSZKMEI', 'Szoftverfejlesztés Tanszék'),
(17, 'Képrészlet sokszorozásának felderítése digitális képeken', '2023/2024/1', '2023/2024/1', 3, 'KNYKSN', 'BSZKPTI', 'Képfeldolgozás és Számítógépes Grafika Tanszék'),
(18, 'Képskálázó eljárások', '2020/2021/1', '2020/2021/1', 2, 'QETTWT', 'BSZKMEI', 'Képfeldolgozás és Számítógépes Grafika Tanszék'),
(19, 'Zöld Kémia: Fenntartható Módszerek és Anyagok a Kémiai Folyamatokban', '2015/2016/1', '2015/2016/1', 1, 'YNNGGW', 'BSZKKMI', 'Alkalmazott és Környezeti Kémiai Tanszék'),
(20, 'Polimerek és Nanotechnológia: Új Generációs Anyagok Fejlesztése', '2022/2023/2', '2022/2023/2', 4, 'YNVVOW', 'BSZKKMI', 'Alkalmazott és Környezeti Kémiai Tanszék');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `hallgato`
--

CREATE TABLE `hallgato` (
  `egyetemiAzonosito` char(6) COLLATE utf8_hungarian_ci NOT NULL,
  `jogviszony` varchar(7) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `hallgato`
--

INSERT INTO `hallgato` (`egyetemiAzonosito`, `jogviszony`) VALUES
('CCCCCC', 'aktív'),
('FNJOSN', 'aktív'),
('HSEHSE', 'aktív'),
('KGHAGK', 'aktív'),
('KNYKSN', 'aktív'),
('PPPPPP', 'aktív'),
('QETTWT', 'aktív'),
('YNNGGW', 'aktív'),
('YNVVOW', 'aktív'),
('ZS10Y3', 'aktív');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `intezet`
--

CREATE TABLE `intezet` (
  `intezetNev` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `karNev` varchar(10) COLLATE utf8_hungarian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `intezet`
--

INSERT INTO `intezet` (`intezetNev`, `karNev`) VALUES
('Alkalmazott Egészségtudományi és Környezeti Nevelés Intézet', 'JGYPK'),
('Alkalmazott Humántudományi Intézet', 'JGYPK'),
('Alkalmazott Pedagógiai Intézet', 'JGYPK'),
('Alkalmazott Társadalomismereti és Kisebbségpolitikai Intézet', 'JGYPK'),
('Művészeti Intézet', 'JGYPK'),
('Nemzetiségi Intézet', 'JGYPK'),
('Szakképzési, Felnőttképzési és Tudásmenedzsment Intézet', 'JGYPK'),
('Testnevelési és Sporttudományi Intézet', 'JGYPK'),
('Biológia Intézet', 'TTIK'),
('Bolyai Intézet', 'TTIK'),
('Fizikai Intézet', 'TTIK'),
('Földrajzi és Földtudományi Intézet', 'TTIK'),
('Informatikai Intézet', 'TTIK'),
('Kémiai Intézet', 'TTIK');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `jar`
--

CREATE TABLE `jar` (
  `szakAzonosito` varchar(25) COLLATE utf8_hungarian_ci NOT NULL,
  `egyetemiAzonosito` char(6) COLLATE utf8_hungarian_ci NOT NULL,
  `kezdesSzemesztere` char(11) COLLATE utf8_hungarian_ci NOT NULL,
  `vegzesSzemesztere` char(11) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `diplomaSorszama` varchar(25) COLLATE utf8_hungarian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `jar`
--

INSERT INTO `jar` (`szakAzonosito`, `egyetemiAzonosito`, `kezdesSzemesztere`, `vegzesSzemesztere`, `diplomaSorszama`) VALUES
('BSZKKMI', 'YNNGGW', '2013/2014/2', '2015/2016/1', 'WAWTOITWOPJPOJWTPTJWOATWJ'),
('BSZKKMI', 'YNVVOW', '2018/2019/2', '2022/2023/2', 'IHGWA8W9RTH8A25H2IHTKTWHT'),
('BSZKMEI', 'FNJOSN', '2020/2021/2', '2023/2024/1', 'AOWPJWGOWOAGWOAGWJAGWJOAG'),
('BSZKMEI', 'KGHAGK', '2016/2017/1', '2018/2019/2', 'OWTJATWOPAWTOJWOJTWOJAWTJ'),
('BSZKMEI', 'QETTWT', '2017/2018/1', '2020/2021/1', 'TAWPWOATWOATWTOWPJTWPJOTW'),
('BSZKPTI', 'FNJOSN', '2018/2019/1', '2021/2022/1', 'WAHGWHGWOAHPGWAGWPHOWHPOA'),
('BSZKPTI', 'KNYKSN', '2012/2013/1', '2015/2016/1', 'AGWNAGPOWGWGPGWAGWKAGWNGA'),
('BSZKUFO', 'HSEHSE', '2020/2021/2', '2023/2024/1', 'GWAWGWGGWWGWGSEHSEHSEHSEH');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `kar`
--

CREATE TABLE `kar` (
  `karNev` varchar(10) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `kar`
--

INSERT INTO `kar` (`karNev`) VALUES
('JGYPK'),
('TTIK');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szak`
--

CREATE TABLE `szak` (
  `szakAzonosito` varchar(25) COLLATE utf8_hungarian_ci NOT NULL,
  `szaknev` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `karNev` varchar(10) COLLATE utf8_hungarian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `szak`
--

INSERT INTO `szak` (`szakAzonosito`, `szaknev`, `karNev`) VALUES
('BSZKBIM', 'biomérnök', 'TTIK'),
('BSZKBIO', 'biológia', 'TTIK'),
('BSZKENE', 'zenekultúra', NULL),
('BSZKFIZ', 'fizika', 'TTIK'),
('BSZKFOL', 'földrajz', 'TTIK'),
('BSZKFOT', 'földtudomány', 'TTIK'),
('BSZKGAI', 'gazdaságinformatikus', 'TTIK'),
('BSZKGYO', 'gyógypedagógia', NULL),
('BSZKKMI', 'kémia', 'TTIK'),
('BSZKKOR', 'környezetmérnök', 'TTIK'),
('BSZKKSS', 'képi ábrázolás', NULL),
('BSZKMAT', 'matematika', 'TTIK'),
('BSZKMEI', 'mérnökinformatikus', 'TTIK'),
('BSZKOVO', 'óvodapedagógus', NULL),
('BSZKPTI', 'programtervező informatikus', 'TTIK'),
('BSZKTAN', 'tanító', NULL),
('BSZKUFO', 'üzemmérnök-informatikus', 'TTIK'),
('BSZKVEM', 'vegyészmérnök', 'TTIK'),
('BSZKVIL', 'villamosmérnök', 'TTIK');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szakintezetek`
--

CREATE TABLE `szakintezetek` (
  `szakAzonosito` varchar(25) COLLATE utf8_hungarian_ci NOT NULL,
  `intezetNev` varchar(100) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `szakintezetek`
--

INSERT INTO `szakintezetek` (`szakAzonosito`, `intezetNev`) VALUES
('BSZKBIM', 'Biológia Intézet'),
('BSZKBIO', 'Biológia Intézet'),
('BSZKENE', 'Művészeti Intézet'),
('BSZKFIZ', 'Fizikai Intézet'),
('BSZKFOL', 'Földrajzi és Földtudományi Intézet'),
('BSZKFOT', 'Földrajzi és Földtudományi Intézet'),
('BSZKGAI', 'Informatikai Intézet'),
('BSZKGYO', 'Alkalmazott Pedagógiai Intézet'),
('BSZKKMI', 'Kémiai Intézet'),
('BSZKKOR', 'Földrajzi és Földtudományi Intézet'),
('BSZKKSS', 'Művészeti Intézet'),
('BSZKMAT', 'Bolyai Intézet'),
('BSZKMEI', 'Informatikai Intézet'),
('BSZKOVO', 'Alkalmazott Pedagógiai Intézet'),
('BSZKPTI', 'Informatikai Intézet'),
('BSZKTAN', 'Alkalmazott Pedagógiai Intézet'),
('BSZKUFO', 'Informatikai Intézet'),
('BSZKVEM', 'Kémiai Intézet'),
('BSZKVIL', 'Informatikai Intézet');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szemely`
--

CREATE TABLE `szemely` (
  `egyetemiAzonosito` char(6) COLLATE utf8_hungarian_ci NOT NULL,
  `elotag` varchar(5) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `vezeteknev` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `keresztnev` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `jelszo` varchar(128) COLLATE utf8_hungarian_ci NOT NULL,
  `jogosultsag` varchar(20) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `szemely`
--

INSERT INTO `szemely` (`egyetemiAzonosito`, `elotag`, `vezeteknev`, `keresztnev`, `jelszo`, `jogosultsag`) VALUES
('AAAAAA', '', 'Admin', 'Aladár', '$2a$10$HMAGE4ZWEalYkw2PM/5Df.gr8EqZDUBux5KaWz4JhNOJHhNW2QPKO', 'ROLE_ADMIN'),
('AABBCC', 'Dr.', 'Belső', 'Béla', '$2a$10$aeoOs3am9meJKizHR3LdW.wlLaUCE5xd.3dWL.yx6aZuJsYWoaYXq', 'ROLE_BELSOTV'),
('ABCABC', NULL, 'A', 'A', 'ABCABCABCABC', 'ROLE_ADMIN'),
('CCCCCC', '', 'CCCCCC', 'CCCCCC', '$2a$10$csMHaNPeQjdE9nueI/bYAeq0faMrg8apasuSckklC8ifZqz7pK5VK', 'ROLE_HALLGATO'),
('CCDDEE', 'dr.', 'Belső', 'András', '$2a$10$foxpKyumlOF7cxrvPdNmmuzc/RoVb/FK2P5J8RVGwPya4NyKxtKOq', 'ROLE_BELSOTV'),
('DD55EE', '', 'Belső', 'Elemér', '$2a$10$eN7tmv3TZ4iePpFiYDp10e1XcxG/4cXnbXqIX/Fh3oQz0TiVS2bMm', 'ROLE_BELSOTV'),
('FNJOSN', '', 'Hallgató', 'Dávid', '$2a$10$9x.lbArsclLdJwG.yhOdFuQIEvHMgQdW/ohrJ6XtPOErfhabDQhjW', 'ROLE_HALLGATO'),
('G45AF5', '', 'Külső', 'Izabella', '$2a$10$.6PBUXEZvWQijRE9O7JJYub0RpNYNfeKqPUJn.6X0w/nocH8X6aMu', 'ROLE_KULSOTV'),
('GAYIHG', '', 'Külső', 'Károly', '$2a$10$lCW1ptHkgOvsOgC5AAEwv.F0If0weffD1iTvXLqyqTWuyHIOEtEEO', 'ROLE_KULSOTV'),
('HSEHSE', '', 'Hallgató', 'Éva', '$2a$10$PCujxDA8uccJAvD00d/Ys.wLqx2gTb9v5m6ILrlPXxC.qhlDpbMRW', 'ROLE_HALLGATO'),
('IIIIII', 'Dr.', 'IIIIII', 'IIIIII', '$2a$10$YZeqMW6nAim0A.oIJltMberw/H3tE7Q/tT.EKYhGS7Vd0YNjQA4ty', 'ROLE_BELSOTV'),
('KGHAGK', '', 'Hallgató', 'Helga', '$2a$10$10TaQlwHkjd3A4PHr3L65uy4U9WZ5TGjImhBcvCMwazqvLtfSaYBC', 'ROLE_HALLGATO'),
('KNYKSN', '', 'Hallgató', 'István', '$2a$10$wWmowsEGBzrQ52ZWpP4jSeuSK/xj2j0BXSdtuRMYgXUnjpqwlNcQa', 'ROLE_HALLGATO'),
('NYKVNK', '', 'Külső', 'Elemér', '$2a$10$UaftIkX6xTlyUMQlPMNLz.xmWrkvSBB4Szaa7mXd4M9esEedD2Wcm', 'ROLE_KULSOTV'),
('PPPPPP', 'Dr.', 'PPPPPP', 'PPPPPP', '$2a$10$bl3bvk71EC6T0cMKBVWJqurqtPsaaszrxQW.EDe3ISLYRPoY8USre', 'ROLE_HALLGATO'),
('QETTWT', '', 'Hallgató', 'Krisztina', '$2a$10$G3r0cdDly3ZbeD./j0H.nu2kf2gnpIv0J.2/CkXtgPuuzC.7zmhIO', 'ROLE_HALLGATO'),
('VFQSDG', '', 'Külső', 'János', '$2a$10$03yKASNojUOCRUIHog.YoOEZ9ogAQwkpPObdhqJISzHKIUMdzKSLW', 'ROLE_KULSOTV'),
('VV44AA', 'Prof.', 'Belső', 'József', '$2a$10$vAFM7hz3g66Vp7awdhdXr./gnTJxkdtTpadeh6F0e44cI9Gg5nfJG', 'ROLE_BELSOTV'),
('WATZWW', '', 'Külső', 'István', '$2a$10$Wfci04h7y3CozQfK6/o7QOdlXznXzd9P1OyvwYi/k0Oq.2rswNs1i', 'ROLE_KULSOTV'),
('XXX111', 'Dr.', 'Belső', 'Tamás', '$2a$10$DsXTR1k7Vb7y4vyYc8kjwu2EZS7YsRuC.OfABhYOfTyX8HapVot9i', 'ROLE_BELSOTV'),
('YNNGGW', '', 'Hallgató', 'Liza', '$2a$10$LTyvI7hjYF56XJD.knkIVOuvChXqToYjf4gYZqWKEtvVUiJc6LjVu', 'ROLE_HALLGATO'),
('YNVVOW', '', 'Hallgató', 'Péter', '$2a$10$KDNFxc/sTZyoDtSSBqvk4.uiDcnBxgrLaXU3nl2WniTTsLiUtG222', 'ROLE_HALLGATO'),
('ZS10Y3', '', 'Tóth-Andor', 'Kristóf', '{bcrypt}ZS10Y3ZS10Y3', 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `tanszek`
--

CREATE TABLE `tanszek` (
  `tanszekNev` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `intezetNev` varchar(100) COLLATE utf8_hungarian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `tanszek`
--

INSERT INTO `tanszek` (`tanszekNev`, `intezetNev`) VALUES
('Egészségpszichológia és Mentálhigiéné Tanszék', 'Alkalmazott Egészségtudományi és Környezeti Nevelés Intézet'),
('Egészségszociológia és Életmód Tanszék', 'Alkalmazott Egészségtudományi és Környezeti Nevelés Intézet'),
('Környezet-biológia és Környezeti Nevelés Tanszék', 'Alkalmazott Egészségtudományi és Környezeti Nevelés Intézet'),
('Technika Tanszék', 'Alkalmazott Egészségtudományi és Környezeti Nevelés Intézet'),
('Magyar és Alkalmazott Nyelvészeti Tanszék', 'Alkalmazott Humántudományi Intézet'),
('Modern Nyelvek és Kultúrák Tanszék', 'Alkalmazott Humántudományi Intézet'),
('Gyógypedagógus-képző Tanszék', 'Alkalmazott Pedagógiai Intézet'),
('Óvodapedagógus-képző Tanszék', 'Alkalmazott Pedagógiai Intézet'),
('Szociálpedagógus-képző Tanszék', 'Alkalmazott Pedagógiai Intézet'),
('Tanítóképző Tanszék', 'Alkalmazott Pedagógiai Intézet'),
('Alkalmazott Társadalomtudományok Tanszék', 'Alkalmazott Társadalomismereti és Kisebbségpolitikai Intézet'),
('Biokémiai és Molekuláris Biológiai Tanszék', 'Biológia Intézet'),
('Biotechnológiai Tanszék', 'Biológia Intézet'),
('Élettani, Szervezettani és Idegtudományi Tanszék', 'Biológia Intézet'),
('Embertani Tanszék', 'Biológia Intézet'),
('Genetikai Tanszék', 'Biológia Intézet'),
('Immunológiai Tanszék', 'Biológia Intézet'),
('Mikrobiológiai Tanszék', 'Biológia Intézet'),
('Növénybiológiai Tanszék', 'Biológia Intézet'),
('Ökológiai Tanszék', 'Biológia Intézet'),
('Sejtbiológia és Molekuláris Medicina Tanszék', 'Biológia Intézet'),
('Algebra és Számelmélet Tanszék', 'Bolyai Intézet'),
('Alkalmazott és Numerikus Matematika Tanszék', 'Bolyai Intézet'),
('Analízis Tanszék', 'Bolyai Intézet'),
('Geometria Tanszék', 'Bolyai Intézet'),
('Halmazelmélet és Matematikai Logika Tanszék', 'Bolyai Intézet'),
('Sztochasztika Tanszék', 'Bolyai Intézet'),
('Elméleti Fizikai Tanszék', 'Fizikai Intézet'),
('Kísérleti Fizikai Tanszék', 'Fizikai Intézet'),
('Optikai és Kvantumelektronikai Tanszék', 'Fizikai Intézet'),
('Orvosi Fizikai és Orvosi Informatikai Intézet', 'Fizikai Intézet'),
('Ásványtani, Geokémiai és Kőzettani Tanszék', 'Földrajzi és Földtudományi Intézet'),
('Éghajlattani és Tájföldrajzi Tanszék', 'Földrajzi és Földtudományi Intézet'),
('Földtani és Őslénytani Tanszék', 'Földrajzi és Földtudományi Intézet'),
('Gazdaság- és Társadalomföldrajz Tanszék', 'Földrajzi és Földtudományi Intézet'),
('Geoinformatikai, Természet- és Környezetföldrajzi Tanszék', 'Földrajzi és Földtudományi Intézet'),
('Képfeldolgozás és Számítógépes Grafika Tanszék', 'Informatikai Intézet'),
('Műszaki Informatikai Tanszék', 'Informatikai Intézet'),
('Számítástudomány Alapjai Tanszék', 'Informatikai Intézet'),
('Számítógépes Algoritmusok és Mesterséges Intelligencia Tanszék', 'Informatikai Intézet'),
('Számítógépes Optimalizálás Tanszék', 'Informatikai Intézet'),
('Szoftverfejlesztés Tanszék', 'Informatikai Intézet'),
('Alkalmazott és Környezeti Kémiai Tanszék', 'Kémiai Intézet'),
('Fizikai Kémiai és Anyagtudományi Tanszék', 'Kémiai Intézet'),
('Molekuláris és Analitikai Kémiai Tanszék', 'Kémiai Intézet'),
('Ének-zene Tanszék', 'Művészeti Intézet'),
('Rajz-művészettörténet Tanszék', 'Művészeti Intézet'),
('Német és Német Nemzetiségi Tanszék', 'Nemzetiségi Intézet'),
('Román Nyelv és Irodalom Tanszék', 'Nemzetiségi Intézet'),
('Szlovák Nyelv és Irodalom Tanszék', 'Nemzetiségi Intézet'),
('Informatika Alkalmazásai Tanszék', 'Szakképzési, Felnőttképzési és Tudásmenedzsment Intézet'),
('Mozgóképkultúra Tanszék', 'Szakképzési, Felnőttképzési és Tudásmenedzsment Intézet'),
('Művelődéstudományi Tanszék', 'Szakképzési, Felnőttképzési és Tudásmenedzsment Intézet'),
('Testnevelési és Sporttudományi Tanszék', 'Testnevelési és Sporttudományi Intézet');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `temavezeto`
--

CREATE TABLE `temavezeto` (
  `egyetemiAzonosito` char(6) COLLATE utf8_hungarian_ci NOT NULL,
  `munkakoriBeosztas` varchar(15) COLLATE utf8_hungarian_ci NOT NULL,
  `szerepkor` varchar(16) COLLATE utf8_hungarian_ci NOT NULL,
  `tanszekNev` varchar(100) COLLATE utf8_hungarian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `temavezeto`
--

INSERT INTO `temavezeto` (`egyetemiAzonosito`, `munkakoriBeosztas`, `szerepkor`, `tanszekNev`) VALUES
('AABBCC', 'egyetemi tanár', 'Belső témavezető', 'Szoftverfejlesztés Tanszék'),
('CCDDEE', 'PhD hallgató', 'Belső témavezető', 'Szoftverfejlesztés Tanszék'),
('DD55EE', 'tanársegéd', 'Belső témavezető', 'Képfeldolgozás és Számítógépes Grafika Tanszék'),
('G45AF5', 'nincs', 'Külső témavezető', NULL),
('GAYIHG', 'nincs', 'Külső témavezető', NULL),
('IIIIII', 'egyetemi tanár', 'Belső témavezető', 'Algebra és Számelmélet Tanszék'),
('NYKVNK', 'nincs', 'Külső témavezető', NULL),
('VFQSDG', 'nincs', 'Külső témavezető', NULL),
('VV44AA', 'egyetemi tanár', 'Belső témavezető', 'Alkalmazott és Környezeti Kémiai Tanszék'),
('WATZWW', 'nincs', 'Külső témavezető', NULL),
('XXX111', 'egyetemi tanár', 'Belső témavezető', 'Képfeldolgozás és Számítógépes Grafika Tanszék');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `vezet`
--

CREATE TABLE `vezet` (
  `dolgozatAzonosito` int(11) NOT NULL,
  `egyetemiAzonosito` char(6) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `vezet`
--

INSERT INTO `vezet` (`dolgozatAzonosito`, `egyetemiAzonosito`) VALUES
(11, 'CCDDEE'),
(11, 'G45AF5'),
(12, 'CCDDEE'),
(15, 'CCDDEE'),
(16, 'CCDDEE'),
(17, 'XXX111'),
(18, 'XXX111'),
(19, 'VV44AA'),
(20, 'VV44AA');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `adminisztrator`
--
ALTER TABLE `adminisztrator`
  ADD PRIMARY KEY (`egyetemiAzonosito`);

--
-- A tábla indexei `dolgozat`
--
ALTER TABLE `dolgozat`
  ADD PRIMARY KEY (`dolgozatAzonosito`),
  ADD KEY `dolgozat_ibfk_1` (`egyetemiAzonosito`),
  ADD KEY `dolgozat_ibfk_2` (`szakAzonosito`),
  ADD KEY `dolgozat_ibfk_3` (`tanszekNev`);

--
-- A tábla indexei `hallgato`
--
ALTER TABLE `hallgato`
  ADD PRIMARY KEY (`egyetemiAzonosito`);

--
-- A tábla indexei `intezet`
--
ALTER TABLE `intezet`
  ADD PRIMARY KEY (`intezetNev`),
  ADD KEY `karNev` (`karNev`);

--
-- A tábla indexei `jar`
--
ALTER TABLE `jar`
  ADD PRIMARY KEY (`szakAzonosito`,`egyetemiAzonosito`),
  ADD UNIQUE KEY `diplomaSorszama` (`diplomaSorszama`),
  ADD KEY `egyetemiAzonosito` (`egyetemiAzonosito`);

--
-- A tábla indexei `kar`
--
ALTER TABLE `kar`
  ADD PRIMARY KEY (`karNev`);

--
-- A tábla indexei `szak`
--
ALTER TABLE `szak`
  ADD PRIMARY KEY (`szakAzonosito`),
  ADD UNIQUE KEY `szaknev` (`szaknev`),
  ADD KEY `karNev` (`karNev`);

--
-- A tábla indexei `szakintezetek`
--
ALTER TABLE `szakintezetek`
  ADD PRIMARY KEY (`szakAzonosito`,`intezetNev`),
  ADD KEY `intezetNev` (`intezetNev`);

--
-- A tábla indexei `szemely`
--
ALTER TABLE `szemely`
  ADD PRIMARY KEY (`egyetemiAzonosito`),
  ADD UNIQUE KEY `jelszo` (`jelszo`);

--
-- A tábla indexei `tanszek`
--
ALTER TABLE `tanszek`
  ADD PRIMARY KEY (`tanszekNev`),
  ADD KEY `intezetNev` (`intezetNev`);

--
-- A tábla indexei `temavezeto`
--
ALTER TABLE `temavezeto`
  ADD PRIMARY KEY (`egyetemiAzonosito`),
  ADD KEY `temavezeto_ibfk_2` (`tanszekNev`);

--
-- A tábla indexei `vezet`
--
ALTER TABLE `vezet`
  ADD PRIMARY KEY (`dolgozatAzonosito`,`egyetemiAzonosito`),
  ADD KEY `vezet_ibfk_2` (`egyetemiAzonosito`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `dolgozat`
--
ALTER TABLE `dolgozat`
  MODIFY `dolgozatAzonosito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `adminisztrator`
--
ALTER TABLE `adminisztrator`
  ADD CONSTRAINT `adminisztrator_ibfk_1` FOREIGN KEY (`egyetemiAzonosito`) REFERENCES `szemely` (`egyetemiAzonosito`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `dolgozat`
--
ALTER TABLE `dolgozat`
  ADD CONSTRAINT `dolgozat_ibfk_1` FOREIGN KEY (`egyetemiAzonosito`) REFERENCES `hallgato` (`egyetemiAzonosito`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `dolgozat_ibfk_2` FOREIGN KEY (`szakAzonosito`) REFERENCES `szak` (`szakAzonosito`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `dolgozat_ibfk_3` FOREIGN KEY (`tanszekNev`) REFERENCES `tanszek` (`tanszekNev`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Megkötések a táblához `hallgato`
--
ALTER TABLE `hallgato`
  ADD CONSTRAINT `hallgato_ibfk_1` FOREIGN KEY (`egyetemiAzonosito`) REFERENCES `szemely` (`egyetemiAzonosito`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `intezet`
--
ALTER TABLE `intezet`
  ADD CONSTRAINT `intezet_ibfk_1` FOREIGN KEY (`karNev`) REFERENCES `kar` (`karNev`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Megkötések a táblához `jar`
--
ALTER TABLE `jar`
  ADD CONSTRAINT `jar_ibfk_1` FOREIGN KEY (`egyetemiAzonosito`) REFERENCES `hallgato` (`egyetemiAzonosito`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `jar_ibfk_2` FOREIGN KEY (`szakAzonosito`) REFERENCES `szak` (`szakAzonosito`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `szak`
--
ALTER TABLE `szak`
  ADD CONSTRAINT `szak_ibfk_1` FOREIGN KEY (`karNev`) REFERENCES `kar` (`karNev`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Megkötések a táblához `szakintezetek`
--
ALTER TABLE `szakintezetek`
  ADD CONSTRAINT `szakintezetek_ibfk_1` FOREIGN KEY (`intezetNev`) REFERENCES `intezet` (`intezetNev`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `szakintezetek_ibfk_2` FOREIGN KEY (`szakAzonosito`) REFERENCES `szak` (`szakAzonosito`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `tanszek`
--
ALTER TABLE `tanszek`
  ADD CONSTRAINT `tanszek_ibfk_1` FOREIGN KEY (`intezetNev`) REFERENCES `intezet` (`intezetNev`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Megkötések a táblához `temavezeto`
--
ALTER TABLE `temavezeto`
  ADD CONSTRAINT `temavezeto_ibfk_1` FOREIGN KEY (`egyetemiAzonosito`) REFERENCES `szemely` (`egyetemiAzonosito`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `temavezeto_ibfk_2` FOREIGN KEY (`tanszekNev`) REFERENCES `tanszek` (`tanszekNev`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Megkötések a táblához `vezet`
--
ALTER TABLE `vezet`
  ADD CONSTRAINT `vezet_ibfk_1` FOREIGN KEY (`dolgozatAzonosito`) REFERENCES `dolgozat` (`dolgozatAzonosito`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vezet_ibfk_2` FOREIGN KEY (`egyetemiAzonosito`) REFERENCES `temavezeto` (`egyetemiAzonosito`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
