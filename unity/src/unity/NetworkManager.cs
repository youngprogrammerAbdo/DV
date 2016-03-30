using UnityEngine;
using System.Collections;

public class NetworkManager : Photon.MonoBehaviour {

    public string verNum = "0.1";
    public string roomName = "room1";
    public Transform spawnPoint;
    public GameObject playerprefbs;
    public bool isConnected = false;
	// Use this for initialization
	void Start () {
        PhotonNetwork.ConnectUsingSettings("0.2");
        Debug.Log("Start Connection");
        
    }
    public void OnConnectedToMaster()
    {
        
        PhotonNetwork.JoinOrCreateRoom(roomName,null,null);
        Debug.Log("Start Lobby");
    }
    public void OnJoinedRoom()
    {
        isConnected = true;
        SpawnPlayer();
    }
    void SpawnPlayer() {
        
        GameObject pl = PhotonNetwork.Instantiate(playerprefbs.name, spawnPoint.position, spawnPoint.rotation, 0) as GameObject;
        pl.GetComponent<RigidbodyFPSWalker>().enabled = true;
        pl.GetComponent<RigidbodyFPSWalker>().fpscam.SetActive(true);
        Debug.Log("Player Created");
    }
	// Update is called once per frame
	void Update () {
        
	}
}
