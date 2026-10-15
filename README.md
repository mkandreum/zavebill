<div align="center">

# 💸 ZaveBill

**Finanzas personales: gastos, metas y gráficas, 100 % offline**

*Un producto de [Xyon Platforms](https://github.com/mkandreum)*

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=flat&logo=android&logoColor=white)
![WebView](https://img.shields.io/badge/WebView-4285F4?style=flat&logo=googlechrome&logoColor=white)

</div>

---

## ¿Qué es ZaveBill?

ZaveBill es una app Android de finanzas personales construida como una WebView con una interfaz web completa empaquetada en la app (`assets/index.html`). Registra gastos e ingresos, saca medias, calcula cuánto te falta para tus metas y lo dibuja todo con Chart.js. Los datos se guardan en `localStorage` del propio dispositivo: sin servidores y sin cuentas.

## ✨ Funcionalidades

- **Dashboard** por mes y año con resumen y gráfica de gastos
- **Gastos e ingresos** por categoría, con iconos, descripción y marcas de gasto recurrente
- **Metas**: define un objetivo y su progreso se calcula y se anima solo
- **Progreso** con gráficas de evolución (`expense-chart`, `summary-chart`)
- **Herramientas**: calculadora de interés compuesto y simulador de nómina
- **Temas** claro/oscuro y onboarding con nombre de usuario
- **Copia de seguridad**: `saveFile` guarda/restaura tus datos en un archivo JSON con el selector de archivos del sistema
- **100 % offline**: toda la lógica va dentro del APK

## 🛠️ Stack técnico

| Capa | Tecnología |
|------|----------|
| Lenguaje | Kotlin (núcleo nativo mínimo) |
| Interfaz | WebView + puente `@JavascriptInterface` (`Android.saveFile`) |
| Datos | `localStorage` del WebView + backup JSON vía SAF (`CREATE_DOCUMENT`) |
| Gráficos | Chart.js + chartjs-adapter-date-fns + chartjs-plugin-datalabels (CDN) |
| Tema | `Theme.FitnessXyonPro`, tipografía Poppins |
| Licencia | Google Play License Check (pairip) |

minSdk 27, targetSdk 36.

## 📁 Estructura del repositorio

Repositorio de **análisis** del APK descompilado, no del proyecto Android original:

```
01_zip/      Extracto crudo del APK (classes.dex, assets, META-INF)
02_apktool/  apktool: AndroidManifest.xml decodificado, smali/ y res/
03_jadx/     JADX: fuentes Java decompiladas + recursos
RESUMEN.txt  Inventario de archivos del descompilado
```

### Cómo se regenera

```bash
unzip com.zavebill.xyon.pro-2.apk -d 01_zip
apktool d com.zavebill.xyon.pro-2.apk -o 02_apktool
jadx -d 03_jadx com.zavebill.xyon.pro-2.apk
```

## 🏢 Xyon Platforms

ZaveBill es un producto desarrollado y mantenido por **Xyon Platforms**, empresa especializada en soluciones digitales para negocios locales y pymes.

> © Xyon Platforms — Todos los derechos reservados
