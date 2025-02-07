FROM httpd:2.4-bookworm
## install openidc module
RUN apt-get update && apt-get install --no-install-recommends -y libapache2-mod-auth-openidc && \
     rm -rf /var/lib/apt/lists/* && \
     ln -s /usr/lib/apache2/modules/mod_auth_openidc.so /usr/local/apache2/modules

## Append sso.conf at the end of httpd.conf
COPY ./sso.conf /tmp/tmp.conf
RUN printf "\n\n" >> /usr/local/apache2/conf/httpd.conf && \
    cat /tmp/tmp.conf >> /usr/local/apache2/conf/httpd.conf && rm -rf /tmp/tmp.conf