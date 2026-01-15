# 🪙 CoinMarketCap GUI Automation Bot
> **High-performance Web Automation engine built with Java 21 and Maven.**

[![Java Version](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Build-Maven-C71A36?style=for-the-badge&logo=apache-maven)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)](https://opensource.org/licenses/MIT)



## 📖 Overview / Resumen

**EN:** A sophisticated automation tool that bypasses expensive API tier limitations by interacting directly with the CoinMarketCap Web Interface. Using **Java 21**, it ensures robust performance and modern syntax for data extraction.

**ES:** Una herramienta de automatización avanzada que evita las limitaciones de las APIs de pago mediante la interacción directa con la interfaz web de CoinMarketCap. Utiliza **Java 21** para garantizar un rendimiento robusto y una sintaxis moderna en la extracción de datos.

---

## 🛠️ Stack Tecnológico / Tech Stack

### ☕ Java 21
Hemos seleccionado la versión **LTS (Long Term Support)** más reciente de Java para aprovechar:
* **Virtual Threads:** Optimización en la gestión de hilos para procesos de red.
* **Modern Syntax:** Mejor legibilidad y mantenimiento del código de automatización.

### 🏗️ Apache Maven
Utilizamos Maven como motor de construcción y gestión de dependencias para:
* **Automatización de ciclo de vida:** Compilación, testing y empaquetado estandarizado.
* **Gestión de Dependencias:** Manejo automático de librerías como Selenium y Dotenv sin conflictos.

---

## ⚙️ Configuration / Configuración

Create a `.env` file in the root directory:

```env
# --- Connection Settings ---
URL_WEB_PAGE=[https://coinmarketcap.com/](https://coinmarketcap.com/)

# --- Target Assets (Slug based) ---
COINS_TO_CONSULT=decentraland,virtual-protocol,lido-dao,xrp,bitcoin,ethereum

# --- Storage Settings ---
PATH_JSON_FILE=/your/absolute/path/here
JSON_FILE_NAME=coins.json
