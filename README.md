# Trade-Data-Feeder
The Trade Data Feeder application fetch the stock news information from opensource api.The Purpose of this application to have hands-on experience in writing kubernetes deployment configs
And use Envoy proxy as service proxy for cloud Native applications.

## Run Application Locally:

* Step 1: SignUp https://www.marketaux.com/register to get API Token

* Step 2: Build the Application using gradle

* Step 3: Update the marketaux.url in the application.yaml as "https://api.marketaux.com/v1/news/all" 

* Step 4: Update the marketaux.magicLetters with your API Token

* Step 5: Run as Spring boot application

## Run this application on Lens Desktop

* Step 1: Build docker image using the below command\
  ```docker build -t yourRepositoryHere/trade-data-feeder:latest .``` \
  Note: Replace the "yourRepositoryHere" with your dockerhub repository 
* Step 2: Push the docker image to docker hub repository \
  ```docker push yourRepositoryHere/trade-data-feeder:latest ``` \
* Step 3: In the project root directory run the below command to deploy the application in kubernetes  \
   ```kubectl apply -f  deployment/ ``` \
* Step 4: In lens Catalog, find the rancher-desktop kubeconfig; Add the rancher-desktop to hot bar by clicking "Add to Hot Bar"
* Step 5: Click on the "trade-data-feeder" pod in lens, and Forward the port 9080, In "Local port to forward from:" field use the port "61747"
* Step 6: Open the browser and invoke the endpoint\
```http://localhost:61747/api/v1/stock/TSLA```

## Downloads:
* Download Rancher Desktop from [RANCHER DESKTOP](https://rancherdesktop.io/)
* create your own docker hub repository from [DOCKER HUB REPOSITORY](https://hub.docker.com/repositories/merugu) 
  Note: Make sure "dockerd" is enabled in Rancher desktop
* Download Lens Desktop from here [LENS DESKTOP](https://k8slens.dev/) 








