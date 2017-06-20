cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/conf
CONF_FILE=$CONF_DIR/dubbo.properties

export JAVA_HOME=/opt/tomcat/jdk1.8.0_91
export JAVA_BIN=/opt/tomcat/jdk1.8.0_91/bin
export PATH=$JAVA_BIN:$PATH