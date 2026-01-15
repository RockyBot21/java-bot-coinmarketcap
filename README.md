# Java Bot CoinMarketCap (GUI Automation) 🤖🪙

Este proyecto es un bot desarrollado en **Java** diseñado para interactuar automáticamente con la interfaz gráfica de **CoinMarketCap**. El bot automatiza la navegación web para consultar datos de criptomonedas específicas y exportarlos a un archivo local en formato JSON.

## 📋 Descripción

A diferencia de los bots que utilizan APIs pagas, este bot realiza **Web Automation** para extraer información directamente de la página de CoinMarketCap. Es ideal para tareas de monitoreo personalizadas y recolección de datos sin depender de los límites de una API Key gratuita.

## ⚙️ Configuración del Sistema

El bot se parametriza totalmente a través de un archivo de variables de entorno. 

### 1. Crear archivo .env
Para que el bot funcione, debes crear un archivo llamado `.env` en la raíz del directorio `example-bot` con la siguiente estructura:

```env
# URL de acceso
URL_WEB_PAGE = [https://coinmarketcap.com/](https://coinmarketcap.com/)

# Lista de criptomonedas a consultar (separadas por coma)
COINS_TO_CONSULT = decentraland, virtual-protocol, lido-dao, xrp, bitcoin, ethereum

# Ruta absoluta donde se guardará el archivo generado
PATH_JSON_FILE = /home/user/Documents/java_projects/example-bot

# Nombre del archivo de salida
JSON_FILE_NAME = coins.json
===============================================================================================================================================================
# Java Bot CoinMarketCap (GUI Automation) 🤖🪙

This project is a **Java-based** bot designed to automatically interact with the **CoinMarketCap** graphical user interface. The bot automates web navigation to query data for specific cryptocurrencies and exports the results to a local JSON file.

## 📋 Description

Unlike bots that rely on paid APIs, this bot performs **Web Automation** to extract information directly from the CoinMarketCap website. It is ideal for personalized monitoring tasks and data collection without being subject to the limitations of a free API Key.

## ⚙️ System Configuration

The bot is fully parameterized through an environment variables file.

### 1. Create .env file
For the bot to function correctly, you must create a file named `.env` in the root of the `example-bot` directory with the following structure:

```env
# Access URL
URL_WEB_PAGE = [https://coinmarketcap.com/](https://coinmarketcap.com/)

# List of cryptocurrencies to consult (comma-separated)
COINS_TO_CONSULT = decentraland, virtual-protocol, lido-dao, xrp, bitcoin, ethereum

# Absolute path where the generated file will be saved
PATH_JSON_FILE = /home/user/Documents/java_projects/example-bot

# Output file name
JSON_FILE_NAME = coins.json
