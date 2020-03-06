import React, { Component } from 'react';
import {  Platform, View, Text,NativeModules, TouchableOpacity,StyleSheet } from 'react-native';

const Bridge = NativeModules.BridgeModule;

export default class App extends Component{
  constructor(props) {
    super(props);
    this.state = {
      value:0
    };
  }

  handlePlatform(flag){
    if(Platform.OS == "android"){
      this.handleBridge(flag);
    }
    else if(Platform.OS == "ios"){
      console.log('ios');
    }
  }

  handleBridge(flag){
    let bridgeValue;
    let {value} = this.state;
    if(flag){
      bridgeValue=value+1;
      this.setState({value:value+1},() =>{Bridge.ShowMessage("This is "+ bridgeValue +" times bridge created. :)", 5000)});
    }
    else{
      bridgeValue=value-1;
      this.setState({value:value-1},() =>{Bridge.ShowMessage("This is "+ bridgeValue +" times bridge created. :)", 5000) });
    }
  }

  render() {
    return (
      <View style={{flex:1, justifyContent:'center', alignItems: 'center'}}>
        <View style={{flexDirection:'row'}}>
        <TouchableOpacity
    style={[styles.Buttons,{backgroundColor:'lightblue',}]} 
        onPress={()=>{this.handlePlatform(true)}}>
          <Text style={styles.Text}>Add!</Text>
        </TouchableOpacity>
        <TouchableOpacity
        style={[styles.Buttons,{backgroundColor:'red',}]} 
        onPress={()=>{this.handlePlatform(false)}}>
          <Text style={styles.Text}>Subtract!</Text>
        </TouchableOpacity>
        </View>

<Text style={styles.Title}> Bridged App</Text>
 </View>
    );
  }
}

const styles = StyleSheet.create({
  Buttons: {
    width:'50%',
    borderWidth:1,
    padding:10,
    alignItems:'center'
  },
  Text:{
    fontSize:15,
    color:'#FFF'
  },
  Title:{
    padding:20, 
    fontWeight:'bold', 
    fontSize:20}
});
