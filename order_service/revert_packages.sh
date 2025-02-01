#!/bin/bash

# Update package declarations
find . -type f -name "*.java" -exec sed -i '' 's/package com\.ecommerce\.app/package multiwarehouse.ecommerce/g' {} +
find . -type f -name "*.java" -exec sed -i '' 's/package com\.ecommerce\.app\.common/package multiwarehouse.common/g' {} +
find . -type f -name "*.java" -exec sed -i '' 's/package com\.ecommerce\.app\.infra/package multiwarehouse.infra/g' {} +

# Update import statements
find . -type f -name "*.java" -exec sed -i '' 's/import com\.ecommerce\.app/import multiwarehouse.ecommerce/g' {} +
find . -type f -name "*.java" -exec sed -i '' 's/import com\.ecommerce\.app\.common/import multiwarehouse.common/g' {} +
find . -type f -name "*.java" -exec sed -i '' 's/import com\.ecommerce\.app\.infra/import multiwarehouse.infra/g' {} +
