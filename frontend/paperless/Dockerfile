## STAGE 1: Build ##
FROM node:20 as builder

WORKDIR /app

COPY package*.json ./

RUN npm ci

COPY . .

RUN npm run build --prod

## STAGE 2: Nginx Setup ##
FROM nginx:latest

WORKDIR /app

# Copy the build output from STAGE 1 to the Nginx html directory
COPY --from=builder /app/dist/paperless-ui /usr/share/nginx/html

# Optionally, if you have a custom Nginx configuration:
COPY conf/nginx.conf /etc/nginx/nginx.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
