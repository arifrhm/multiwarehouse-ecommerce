# multiwarehouse-ecommerce
Multi-Warehouse E-commerce is an e-commerce application that utilizes more than one warehouse for item storage. The implementation of this system aims to increase shipping speed and reduce shipping costs.

## Useful commands
### To generate dependency image
- Move to the target or project folder
- Then run this command:
``mvn com.github.ferstl:depgraph-maven-plugin:aggregate -DcreateImage=true -DreduceEdges=false -Dscope=compile``