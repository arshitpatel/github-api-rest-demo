# github-api-rest-demo
Contains REST API that will provide git api support. For example it will search repositories by language name.

### How to RUN in local

#### First way through mvn build 

1. Clone this repository and build using command `mvn clean install`
2. Run this project as Application or run App.java class
3. server will start on port `9000`. will configurable in application.properties file.

#### Second way through jar

1. I have checked in jar also. So we can run directly using jar. 
2. download this jar and run below command
```
java -jar demo-0.0.1-SNAPSHOT.jar

```
3. this will start server at port `9000`


### API Info

1. We have search api implemented here. Below informatin will give idea about api

API endpoint : `/search/repositories/{language}`. Where we can search repos by language name. 
Method type : `GET`
#### Headers : All headers are optionals.

```
sort -> Sorts the results of your query by number of stars, forks, or help-wanted-issues or how recently the items were updated.
order -> Determines whether the first search result returned is the highest number of matches (desc) or lowest number of matches (asc). This parameter is ignored unless you provide sort.
per_page -> Results per page (max 100)
page -> Page number of the results to fetch.

```

For example :

```
curl -X GET \
  http://localhost:9000/search/repositories/assembly \
  -H 'perPage: 3'
```

#### Sample Output

```
{
    "items": [
        {
            "owner": {
                "login": "chrislgarry"
            },
            "id": "18408635",
            "name": "Apollo-11",
            "git_url": "git://github.com/chrislgarry/Apollo-11.git"
        },
        {
            "owner": {
                "login": "microsoft"
            },
            "id": "138634298",
            "name": "MS-DOS",
            "git_url": "git://github.com/microsoft/MS-DOS.git"
        },
        {
            "owner": {
                "login": "compiler-explorer"
            },
            "id": "4414698",
            "name": "compiler-explorer",
            "git_url": "git://github.com/compiler-explorer/compiler-explorer.git"
        }
    ]
}

```
