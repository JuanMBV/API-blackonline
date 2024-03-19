# Getting started

## Clone the repository

```bash
git clone https://github.com/JuanMBV/API-blackonline.git
```

## Generate .jar for the project

If you use Maven:

```bash
mvn clean package -DskipTests 
```

If you don't have Maven, see this video: https://www.youtube.com/watch?v=YTvlb6eny_0

## Create docker container

Open the terminal and put:

```bash
docker compose up -d --build
```