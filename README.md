# image-uploader-master
## About this app
Solution for a challenge ['Image Uploader' from devChallenges](https://devchallenges.io/challenges/O2iGT9yBd6xZBrOcVirx)

## OverView
You drag and drop an image or choose it from your folder.
![overview_1](https://user-images.githubusercontent.com/75245305/148635019-24b3c60a-c0f9-42e2-928e-4db064bad769.png)

Loading bar is showed when uploading
![overview_2](https://user-images.githubusercontent.com/75245305/148635025-842c7d11-2af0-4987-bf7b-578c26f5207f.png)

When the image is uploaded, You can see the image and copy it 
![overview_3](https://user-images.githubusercontent.com/75245305/148635027-48bb2b8c-b45c-46f2-8660-73931c4a7265.png)

## How to use
1. git clone https://github.com/youme1133/image-uploader-master.git

2. Install MySQL and create a schema
```bash
username: root
password: mysql
scheme: dev-challenges
```

3. Run the app
```bash
# Run SpringBoot
$ ..\image-uploader-api gradlew.bat bootRun
# Run Vue
$ ..\image-uploader-client npm run serve
```

Reference URL
https://qiita.com/shunp/items/abea7fa01e7a664c85da
