[![Build Status](https://travis-ci.org/charite/weka-GWAVA.svg?branch=master)](https://travis-ci.org/charite/weka-GWAVA)
[![API Docs](https://img.shields.io/badge/api-v0.2-blue.svg?style=flat)](http://charite.github.io/weka-GWAVA/api/0.1/)
[![license](https://img.shields.io/badge/licence-GNU%20GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0.txt)

# weka-GWAVA

Weka implementation of the GWAVA method from 
Ritchie, G. R. S., Dunham, I., Zeggini, E., & Flicek, P. (2014). Functional annotation of noncoding sequence variants. Nat Methods, 11(3), 294–296. http://doi.org/10.1038/nmeth.2832

## Requirements

weka-GWAVA requires java 8 and higher. It can be used as a [Weka](http://www.cs.waikato.ac.nz/~ml/weka/) plugin using version 3.9 or higher. To build the program it is recommended to use [Maven](https://maven.apache.org/).

## Installation from GitHub sources

To use weka-GWAVA in [Weka](http://www.cs.waikato.ac.nz/~ml/weka/) three steps are needed.

1. Clone this repository.
2. Compile the java classes and create a Weka plugin using Maven   
3. Load the plugin into your Weka Package Manager

### Clone this repository

Use your terminal and go to a folder where you want to checkout weka-GWAVA. Then run:

```
git clone https://github.com/charite/weka-GWAVA.git
```

### Compile the java classes and create the Weka plugin

Go to your repository and create a jar file of weka-GWAVA using Maven.

```
cd weka-GWAVA

mvn clean install package
```

Now you should have the  `weka-GWAVA-0.1.jar` in the folder `target/`. The package phase of Maven creates also the Weka  file `weka-GWAVA-0.1-weka.zip`. It is located in the `target/` folder.

### Load the plugin into your Weka Package Manager

Open Weka, go to the package manager, and load the file `weka-GWAVA-0.2-weka.zip` into it.  Look at the [Weka wiki](http://weka.wikispaces.com/How+do+I+use+the+package+manager%3F) for more information about the Weka Package Manager.
