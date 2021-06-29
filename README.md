# xml_car_catalog_parser

en: A console program that counts the number of unique values of the "name" attribute of the "modification" tag ru:
Консольная программа, подсчитывающая количество уникальных значений атрибута "name" тега "modification"

## Tech

en: The technologies we use ru: Применяемые нами технологии

- [JAVA](https://libericajdk.ru/pages/downloads/#/java-11-lts) - Java 11+ required

## Building for source

en: for build source run command ru: для сборки проекта наберите команду

en: _For Linx system_
ru: _Для Linx систем_

```sh
mvnw compile
```

en: _For Windows system_
ru: _Для Windows систем_

```sh
mvnw.cmd clean package
```

en: after the build, the files will be available at ru: после сборки файлы будет доступен по адресу

```
<progectDir>\target\parser.jar
```

## Use

en: to work with the program, just run ru: для работы с программой достаточно запустить

```
java -jar <progectDir>\target\parser.jar file.xml
```

en: at the output, you will get the number ru: на выходе вы получите число

## Support

en: it supports working with both a local file and a network file ru: поддерживается работа как с локальным файлом так и
с сетевым

```
file.xml
```

of

```
https://auto-export.s3.yandex.net/auto/price-list/catalog/cars.xml
```
