
class App extends React.Component {
    state = {
        objects:[],
        filtered: []
    }

    componentDidMount = () => {
        axios.get('/objects').then(
            (response) => {
                this.setState({
                    objects:response.data
                })
                console.log(this.state.objects)
            }
        )
    }

    createobject = (event) => {
        event.preventDefault();
        axios.post(
            '/objects',
            {
                itemName:this.state.newobjectitemName,
                department:this.state.newobjectdepartment,
                quantity:this.state.newobjectquantity,
            }
        ).then(
            (response) => {
                this.setState({
                    objects:response.data
                })
            }
        )
    }

    changeNewobjectquantity = (event) => {
        this.setState({
            newobjectquantity:event.target.value
        });
    }

    changeNewobjectdepartment = (event) => {
        this.setState({
            newobjectdepartment:event.target.value
        });
    }

    changeNewobjectitemName = (event) => {
        this.setState({
            newobjectitemName:event.target.value
        });
    }

    deleteObject = (event) => {
        axios.delete('/objects/' + event.target.value).then(
            (response) => {
                this.setState({
                    objects:response.data
                })
            }
        )

    }

    updateObject = (event) => {
        event.preventDefault();
        const id = event.target.getAttribute('id');
        axios.put(
            '/objects/' + id,
            {
                itemName:this.state.updateObjectitemName,
                department:this.state.updateObjectdepartment,
                quantity:this.state.updateObjectquantity
            }
        ).then(
            (response) => {
                this.setState({
                    objects:response.data,
                    itemName:'',
                    department:'',
                    quantity: null
                })
            }
        )
    }

    changeupdateObjectitemName = (event) => {
        this.setState(
            {
                updateObjectitemName:event.target.value
            }
        )
    }

    changeupdateObjectdepartment = (event) => {
        this.setState(
            {
                updateObjectdepartment:event.target.value
            }
        )
    }

    changeupdateObjectquantity = (event) => {
        this.setState(
            {
                updateObjectquantity:event.target.value
            }
        )
    }

  handleSearch = (newSearch) => {
      this.setState(
        {
        searchval:event.target.value
        }
      )
      if (search !== '') {
       const filteredData = objects.filter((item) => {
         return Object.values(item).join('').toLowerCase().includes(search.toLowerCase())
       })
       this.setState(
         {
         filtered:filteredData
         }
       )
     } else {
       this.setState(
         {
         filtered:objects
         }
       )
     }
   }


    render = () => {
        return <div>
          <div className="createDiv">
            <h2>List Inventory</h2>
            <form onSubmit={this.createobject}>
                <input onKeyUp={this.changeNewobjectitemName} type="text" placeholder="Item Name" /><br/>
                <input onKeyUp={this.changeNewobjectdepartment} type="text" placeholder="Department" /><br/>
                <input onKeyUp={this.changeNewobjectquantity} type="number" placeholder="Quantity" /><br/>
                <input type="submit" value="List Inventory" />
            </form>
          </div>
        
          <div className="objectsDiv">
            <h2>Inventory Log</h2>
            <ul>
                {
                    this.state.objects
                    .sort(({ id: previousID }, { id: currentID }) => previousID - currentID)
                    .map(
                        (object, index) => {
                          console.log(object);
                          console.log(index)
                            return <li className="listmap" key={index}>

                                <div className="datadiv">
                                  <div>Item Name: {object.itemName}</div> <div>Department: {object.department}</div> <div>Quantity: {object.quantity}</div>
                                </div>

                                <button className="deletebutton" value={object.id} onClick={this.deleteObject}>DELETE</button>

                                <form id={object.id} onSubmit={this.updateObject}>
                                    <input onKeyUp={this.changeupdateObjectitemName} type="text" placeholder="itemName"/><br/>
                                    <input onKeyUp={this.changeupdateObjectdepartment} type="text" placeholder="department"/><br/>
                                    <input onKeyUp={this.changeupdateObjectquantity} type="number" placeholder="quantity" /><br/>
                                    <input type="submit"  value="Update Listing"/>
                                </form>
                            </li>
                        }
                    )
                }
            </ul>
        </div>
      </div>
    }
}

ReactDOM.render(
    <App></App>,
    document.querySelector('main')
)
